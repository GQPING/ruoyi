-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('年度账单', '2000', '1', 'year', 'local/year/index', 1, 0, 'C', '0', '0', 'local:year:list', '#', 'admin', sysdate(), '', null, '年度账单菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('年度账单查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'local:year:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('年度账单新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'local:year:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('年度账单修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'local:year:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('年度账单删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'local:year:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('年度账单导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'local:year:export',       '#', 'admin', sysdate(), '', null, '');