package com.jk.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jk.entity.Admins;
import com.jk.entity.Users;
import com.jk.service.IAdminsService;
import com.jk.service.IUsersService;
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
@RequestMapping("/admins")
public class AdminsController {
    @Autowired
    private IAdminsService adminsService;
    // 1、查询后台所有商品
    @GetMapping("/list")
    public List<Admins> findAll(){
        return adminsService.findAll();
    }
    //2、分页查询
    @GetMapping("/page")
    public ResultUtil list(@RequestParam Integer page, @RequestParam Integer limit,
                           @RequestParam String username, @RequestParam String password){
        //传入分页属性
        Page<Admins> objectPage = new Page<>(page, limit);
        //查询条件
        QueryWrapper<Admins> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.isNotBlank(username),"username",username)
                .like(StringUtils.isNotBlank(password),"password",password)
                .orderByDesc("id");
        //分页查询
        Page<Admins> adminsPage = adminsService.page(objectPage, wrapper);
        //获取数据总条数
        long total = adminsPage.getTotal();
        //数据
        List<Admins> adminsList = adminsPage.getRecords();
        return new ResultUtil(0,total,adminsList);

    }
    //3、新增、修改
    @PostMapping("/save")
    public ResultUtil save(@RequestBody Admins admins){
        System.out.println(admins);
        if (admins.getId()==0){//新增
            adminsService.save(admins);
            return ResultUtil.ok("保存成功！");
        }else {//编辑
            adminsService.updateById(admins);
            return ResultUtil.ok("修改成功！");
        }
    }
    //4、根据id删除
    @GetMapping("/del")
    public ResultUtil edit(@RequestParam int id){
        adminsService.removeById(id);
        return ResultUtil.ok("删除成功！");
    }
    // 5、批量删除
    @PostMapping("/delbat")
    public ResultUtil delbat(@RequestBody List<Integer> ids){
        adminsService.removeBatchByIds(ids);
        return ResultUtil.ok("删除成功！");
    }

    /**
     * 6、导出接口
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) throws Exception {
        // 从数据库查询出所有的数据
        List<Admins> list = adminsService.list();
        // 通过工具类创建writer 写出到磁盘路径
        // ExcelWriter writer = ExcelUtil.getWriter(filesUploadPath + "/用户信息.xlsx");
        // 在内存操作，写出到浏览器
        ExcelWriter writer = ExcelUtil.getWriter(true);
        // 一次性写出list内的对象到excel，使用默认样式，强制输出标题
        writer.write(list, true);

        // 设置浏览器响应的格式
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
        String fileName = URLEncoder.encode("管理员信息表", "UTF-8");
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
        List<Admins> list = reader.readAll(Admins.class);
        System.out.println(list);
        adminsService.saveBatch(list);
        return ResultUtil.ok("上传成功！");
    }


}
