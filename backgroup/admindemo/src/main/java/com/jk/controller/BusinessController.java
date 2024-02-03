package com.jk.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jk.entity.Business;
import com.jk.entity.Goods;
import com.jk.service.IBusinessService;
import com.jk.service.IGoodsService;
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
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private IBusinessService businessService;
    // 1、查询后台所有商家信息
    @GetMapping("/list")
    public List<Business> findAll(){
        return businessService.findAll();
    }
    //2、分页查询
    @GetMapping("/page")
    public ResultUtil list(@RequestParam Integer page, @RequestParam Integer limit,
                           @RequestParam String name, @RequestParam String shopname){
        //传入分页属性
        Page<Business> objectPage = new Page<>(page, limit);
        //查询条件
        QueryWrapper<Business> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(name),"name",name)
                .like(StringUtils.isNotBlank(shopname),"shopname",shopname)
                .orderByDesc("id");
        //分页查询
        Page<Business> businessPage = businessService.page(objectPage, wrapper);
        //获取数据总条数
        long total = businessPage.getTotal();
        //数据
        List<Business> businessList = businessPage.getRecords();
        return new ResultUtil(0,total,businessList);

    }
    //3、新增、修改
    @PostMapping("/save")
    public ResultUtil save(@RequestBody Business business){
        System.out.println(business);
        if (business.getId()==0){//新增
            businessService.save(business);
            return ResultUtil.ok("保存成功！");
        }else {//编辑
            businessService.updateById(business);
            return ResultUtil.ok("修改成功！");
        }
    }
    //4、根据id删除
    @GetMapping("/del")
    public ResultUtil edit(@RequestParam int id){
        businessService.removeById(id);
        return ResultUtil.ok("删除成功！");
    }
    // 5、批量删除
    @PostMapping("/delbat")
    public ResultUtil delbat(@RequestBody List<Integer> ids){
        businessService.removeBatchByIds(ids);
        return ResultUtil.ok("删除成功！");
    }

    /**
     * 6、导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Business> list = businessService.list();
        // 通过工具类创建writer 写出到磁盘路径
        // ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("商家信息表", "UTF-8");
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
        List<Business> list = reader.readAll(Business.class);
        System.out.println(list);
        businessService.saveBatch(list);
        return ResultUtil.ok("上传成功！");
    }


}
