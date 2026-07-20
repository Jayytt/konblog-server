package com.konblog.security;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class StpInterfaceImpl implements StpInterface {
    public List<String> getPermissionList(Object loginId, String loginType) {
        SaSession s = StpUtil.getSessionByLoginId(loginId);
        return s == null ? new ArrayList<>() : s.get(\