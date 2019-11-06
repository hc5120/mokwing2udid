package com.udid.sign.rest;

import com.udid.aop.log.Log;
import com.udid.sign.domain.App;
import com.udid.sign.service.AppService;
import com.udid.system.service.dto.CommonQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangwei
 * @date 2018-11-23
 */
@RestController
@RequestMapping("api")
public class AppController {

    @Autowired
    private AppService appService;


    @Log("查询应用")
    @GetMapping(value = "/apps")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getApps(CommonQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity(appService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @Log("查询应用")
    @GetMapping(value = "/apps")
    @PreAuthorize("hasAnyRole('ADMIN','APP_SELECT','APP_ALL')")
    public ResponseEntity getAppsByMe(CommonQueryCriteria criteria, Pageable pageable) {
        return new ResponseEntity(appService.queryAll(criteria, pageable), HttpStatus.OK);
    }

    @Log("新增应用")
    @PostMapping(value = "/apps")
    @PreAuthorize("hasAnyRole('ADMIN','APP_ALL','APP_CREATE')")
    public ResponseEntity create(@Validated @RequestBody App resources) {
        return new ResponseEntity(appService.create(resources), HttpStatus.CREATED);
    }


    @Log("删除应用")
    @DeleteMapping(value = "/apps/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','APP_ALL','APP_DELETE')")
    public ResponseEntity delete(@PathVariable Long id) {
        appService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
