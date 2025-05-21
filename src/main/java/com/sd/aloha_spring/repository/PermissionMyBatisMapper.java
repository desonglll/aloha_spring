package com.sd.aloha_spring.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sd.aloha_spring.model.entity.Permission;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PermissionMyBatisMapper extends BaseMapper<Permission> {
}
