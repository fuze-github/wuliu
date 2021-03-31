import React, { Component } from "react";
import { Layout, Menu, Breadcrumb } from "antd";
import {
  UserOutlined,
  LaptopOutlined,
  NotificationOutlined,
} from "@ant-design/icons";
import logo from "../../style/image/logo.png"
import head from "../../style/image/head.png"
import { Redirect, Route } from "react-router-dom";
import MyNavLink from "../../components/MyNavLink";
import Seedata from "../personal/seedata";
import Updateword from "../personal/updateword";
import Management from "../management"
export default class Main extends Component {
  render() {
    const { SubMenu } = Menu;
    const { Header, Content, Footer, Sider } = Layout;
    return (
      <div className="main">
        {" "}
        <Layout>
          <Header className="header">
            <div className="logo" />
            <img src={logo} alt="" className="left_logo"/>
            <span>物流管理系统</span>
            <img src={head} alt="" className="headimg"/>
          </Header>
          <Content style={{ padding: "0 50px" }}>
            <Breadcrumb style={{ margin: "16px 0" }}>
              <Breadcrumb.Item>Home</Breadcrumb.Item>
              <Breadcrumb.Item>List</Breadcrumb.Item>
              <Breadcrumb.Item>App</Breadcrumb.Item>
            </Breadcrumb>
            <Layout
              className="site-layout-background"
              style={{ padding: "24px 0" }}
            >
              <Sider className="site-layout-background" width={200}>
                <Menu
                  mode="inline"
                  defaultSelectedKeys={["1"]}
                  defaultOpenKeys={["sub1"]}
                  style={{ height: "100%" }}
                >
                  <SubMenu key="sub1" icon={<UserOutlined />} title="个人信息">
                    <Menu.Item key="1">
                      {" "}
                      <MyNavLink to="/main/seedata">查看信息 </MyNavLink>{" "}
                    </Menu.Item>
                    <Menu.Item key="2">
                      <MyNavLink to="/main/updateword">修改密码 </MyNavLink>
                    </Menu.Item>
                  </SubMenu>
                  <SubMenu
                    key="sub2"
                    icon={<LaptopOutlined />}
                    title="用户管理"
                  >
                    <Menu.Item key="3">
                      <MyNavLink to="/main/management">员工管理 </MyNavLink>{" "}
                    </Menu.Item>
                  </SubMenu>
                  <SubMenu
                    key="sub3"
                    icon={<NotificationOutlined />}
                    title="基础信息"
                  >
                    <Menu.Item key="4">车辆信息</Menu.Item>
                    <Menu.Item key="5">司机信息</Menu.Item>
                    <Menu.Item key="6">配送范围</Menu.Item>
                  </SubMenu>
                  <SubMenu
                    key="sub4"
                    icon={<NotificationOutlined />}
                    title="货物信息"
                  >
                    <Menu.Item key="7">审核货物</Menu.Item>
                    <Menu.Item key="8">货物信息</Menu.Item>
                  </SubMenu>
                  <SubMenu
                    key="sub5"
                    icon={<NotificationOutlined />}
                    title="货物运输"
                  >
                    <Menu.Item key="9">运输途中</Menu.Item>
                    <Menu.Item key="10">货物运达</Menu.Item>
                  </SubMenu>
                  <SubMenu
                    key="sub6"
                    icon={<NotificationOutlined />}
                    title="统计信息"
                  >
                    <Menu.Item key="11">货物统计</Menu.Item>
                  </SubMenu>
                  <SubMenu
                    key="sub7"
                    icon={<NotificationOutlined />}
                    title="系统管理"
                  >
                    <Menu.Item key="12">登录日志</Menu.Item>
                  </SubMenu>
                  <SubMenu
                    key="sub8"
                    icon={<NotificationOutlined />}
                    title="反馈信息"
                  >
                    <Menu.Item key="13">用户反馈</Menu.Item>
                  </SubMenu>
                </Menu>
              </Sider>
              <Content style={{ padding: "0 24px", minHeight: 280 }}>
                <Route path="/main/seedata" component={Seedata} />
                <Route path="/main/updateword" component={Updateword} />
                <Route path="/main/management" component={Management} />
                <Redirect to="/main/seedata"></Redirect>
              </Content>
            </Layout>
          </Content>
          <Footer style={{ textAlign: "center" }}>
            Ant Design ©2018 Created by Ant UED
          </Footer>
        </Layout>
      </div>
    );
  }
}
