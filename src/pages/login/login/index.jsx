import React, { Component } from "react";
import { Form, Input, Button, Tooltip, Select, message } from "antd";
import { login } from "../../../request/network";
import {
  InfoCircleOutlined,
  UserOutlined,
  LockOutlined,
} from "@ant-design/icons";
import { action, observable } from "mobx";
import { inject, observer } from "mobx-react";
@inject("store")
@observer
class LLogin extends Component {
  @observable rule = false;
  @observable password = false;
  @action
  zhuce = () => {
    this.props.history.push("/login/regist");
  };
  getphone = (event) => {
    if (
      /^1(?:3\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\d|9\d)\d{8}$/.test(
        event.target.value
      )
    ) {
      this.rule = true;
    } else {
      this.rule = false;
    }
  };
  getpassword = (e) => {
    if (/^([0-9]|[a-zA-Z]){6,16}$/.test(e.target.value)) {
      this.password = true;
    } else {
      this.password = false;
    }
  };
  onChange = (value) => {
    /*   console.log(value); */
  };

  render() {
    console.log(this.props.store);
    const { Option } = Select;
    const layout = {
      labelCol: {
        span: 8,
      },
      wrapperCol: {
        span: 16,
      },
    };
    const tailLayout = {
      wrapperCol: {
        offset: 8,
        span: 16,
      },
    };

    const onFinish = (values) => {
      if (this.rule && this.password) {
        const obj = {
          phone: values.phone,
          password: values.password,
          judge: values.rules,
        };

        login(obj).then((res) => {
          console.log(res);
          if (res.data.code === 200 && res.data.data[0].judge === "1") {
            sessionStorage.setItem("token", res.data.data[0].token);
            message.success("管理员登录成功");
            this.props.history.push({
              pathname: "/main/seedata",
              query: { id: res.data.data[0].id },
            });
          } else if (res.data.code && res.data.data[0].judge === "2") {
            sessionStorage.setItem("token", res.data.data[0].token);
            message.success("用户登录成功");
            this.props.history.push({
              pathname: "/main/seedata",
              query: { id: res.data.data[0].id },
            });
          } else {
            message.error("填写信息有误");
          }
        });
      }
    };

    const onFinishFailed = (errorInfo) => {
      console.log(errorInfo);
    };

    return (
      <div className="llgion">
        <Form
          {...layout}
          name="basic"
          initialValues={{
            remember: true,
          }}
          onFinish={onFinish}
          onFinishFailed={onFinishFailed}
        >
          <div className="title">
            <p>物流管理系统</p>
          </div>
          <Form.Item
            label="手机"
            name="phone"
            hasFeedback={this.rule}
            validateStatus="success"
            rules={[
              {
                required: true,
                message: "手机号不能为空!",
              },
            ]}
          >
            <Input
              maxLength="11"
              prefix={<UserOutlined className="site-form-item-icon" />}
              suffix={
                <Tooltip title="输入您的手机号">
                  <InfoCircleOutlined style={{ color: "rgba(0,0,0,.45)" }} />
                </Tooltip>
              }
              ref={(val) => (this.phone = val)}
              onChange={this.getphone}
            />
          </Form.Item>
          <Form.Item
            label="密码"
            name="password"
            hasFeedback={this.password}
            validateStatus="success"
            rules={[
              {
                required: true,
                message: "密码不能为空",
              },
            ]}
          >
            <Input.Password
              onChange={this.getpassword}
              prefix={<LockOutlined />}
            />
          </Form.Item>
          <Form.Item
            label="登录身份"
            name="rules"
            rules={[
              {
                required: true,
                message: "请选择登录身份",
              },
            ]}
          >
            <Select
              showSearch
              style={{ width: 200 }}
              placeholder="请选择登录身份"
              onChange={this.onChange}
              allowClear
            >
              <Option value="1">管理员</Option>
              <Option value="2">普通用户</Option>
            </Select>
          </Form.Item>
          <Form.Item {...tailLayout}>
            <Button
              style={{ marginRight: "50px" }}
              type="primary"
              htmlType="submit"
            >
              登录
            </Button>
            <Button onClick={this.zhuce}>注册账号</Button>
          </Form.Item>
        </Form>
      </div>
    );
  }
}
export default LLogin;
