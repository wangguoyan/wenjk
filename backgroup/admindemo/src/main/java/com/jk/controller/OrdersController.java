package com.jk.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jk.entity.Orders;
import com.jk.service.IOrdersService;
import com.jk.utils.ResultUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {
   @Autowired
   private IOrdersService ordersService;
    // 1、查询后台所有商品
    @GetMapping("/list")
    public List<Orders> findAll(){
        return ordersService.findAll();
    }
    //2、分页查询
    @GetMapping("/page")
    public ResultUtil list(@RequestParam Integer page, @RequestParam Integer limit,
                           @RequestParam String goodsid, @RequestParam String goodsname){
        //传入分页属性
        Page<Orders> objectPage = new Page<>(page, limit);
        //查询条件
        QueryWrapper<Orders> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(goodsid),"goodsid",goodsid)
                .like(StringUtils.isNotBlank(goodsname),"goodsname",goodsname)
                .orderByDesc("id");
        //分页查询
        Page<Orders> ordersPage = ordersService.page(objectPage, wrapper);
        //获取数据总条数
        long total = objectPage.getTotal();
        //数据
        List<Orders> ordersList = ordersPage.getRecords();
        return new ResultUtil(0,total,ordersList);

    }
    //3、新增、修改
    @PostMapping("/save")
    public ResultUtil save(@RequestBody Orders orders){
        System.out.println(orders);
        if (orders.getId()==0){//新增
            ordersService.save(orders);
            return ResultUtil.ok("保存成功！");
        }else {//编辑
            ordersService.updateById(orders);
            return ResultUtil.ok("修改成功！");
        }
    }
    //4、根据id删除
    @GetMapping("/del")
    public ResultUtil edit(@RequestParam int id){
        ordersService.removeById(id);
        return ResultUtil.ok("删除成功！");
    }
    // 5、批量删除
    @PostMapping("/delbat")
    public ResultUtil delbat(@RequestBody List<Integer> ids){
        ordersService.removeBatchByIds(ids);
        return ResultUtil.ok("删除成功！");
    }

    /**
     * 6、导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Orders> list = ordersService.list();
        // 通过工具类创建writer 写出到磁盘路径
        // ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("订单信息表", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        ServletOutputStream out = response.getOutputStream();
        writer.flush(out, true);
        out.close();
        writer.close();

    }

    /**
     * excel 7、导入
     * @param file
     * @throws Exception
     */
    @PostMapping("/import")
    public ResultUtil imp(MultipartFile file) throws Exception {
        InputStream inputStream = file.getInputStream();
        ExcelReader reader = ExcelUtil.getReader(inputStream);
        // 方式1：(推荐) 通过 javabean的方式读取Excel内的对象，但是要求表头必须是英文，跟javabean的属性要对应起来
        List<Orders> list = reader.readAll(Orders.class);
        System.out.println(list);
        ordersService.saveBatch(list);
        return ResultUtil.ok("上传成功！");
    }



}
