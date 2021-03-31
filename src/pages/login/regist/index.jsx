import React, { Component } from "react";
import { Form, Input, Button, message, Radio } from "antd";
import { regist } from "../../../request/network";
export default class Regist extends Component {
  state = {
    loginname: false,
    name: false,
    phone: false,
    age: false,
    value: "",
    email: false,
    password:false
  };
  back = () => {
    this.props.history.push("/login/llogin");
  };
  login_name = (e) => {
    if (e.target.value !== "") {
      this.setState({
        loginname: true,
      });
    } else {
      this.setState({
        loginname: false,
      });
    }
  };
  username = (e) => {
    if (e.target.value !== "") {
      this.setState({
        name: true,
      });
    } else {
      this.setState({
        name: false,
      });
    }
  };
  phone = (e) => {
    if (
      /^1(?:3\d|4[4-9]|5[0-35-9]|6[67]|7[013-8]|8\d|9\d)\d{8}$/.test(
        e.target.value
      )
    ) {
      this.setState({
        phone: true,
      });
    } else {
      this.setState({
        phone: false,
      });
    }
  };
  age = (e) => {
    if (e.target.value !== "") {
      this.setState({
        age: true,
      });
    } else {
      this.setState({
        age: false,
      });
    }
  };
  email = (e) => {
    if (
      /^[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*\.[a-z]{2,}$/.test(
        e.target.value
      )
    ) {
      this.setState({
        email: true,
      });
    } else {
      this.setState({
        email: false,
      });
    }
  };
  password = (e)=>{
    if( /^([0-9]|[a-zA-Z]){6,16}$/.test( e.target.value)  ){
      this.setState({
        password:true
      })
    }else{
      this.setState({
        password:false
      })
    }
  }
  render() {
    const { loginname, name, phone, age, value, email,password } = this.state;
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
      if (loginname && name && phone && age && email && password) {
        regist(values).then((res) => {
          if (res.status === 200) {
            message.success("注册成功,即将前往登录页");
            setTimeout(() => {
              this.props.history.push("/login/llogin");
            }, 2000);
          } else {
            message.error("注册失败");
          }
        });
      } else {
        message.error("请按要求填写注册信息");
      }
    };

    const onFinishFailed = (errorInfo) => {
      console.log(errorInfo);
    };

    return (
      <div className="regist">
        <Form
          {...layout}
          name="basic"
          initialValues={{
            remember: true,
          }}
          onFinish={onFinish}
          onFinishFailed={onFinishFailed}
        >
          <Form.Item
            label="登录名"
            name="loginname"
            hasFeedback={loginname}
            validateStatus="success"
            rules={[
              {
                required: true,
                message: "登录名不能为空!",
              },
            ]}
          >
            <Input onChange={this.login_name} autoComplete="off" />
          </Form.Item>
          <Form.Item
            label="密码"
            name="password"
            hasFeedback={password}
            validateStatus="success"
            rules={[
              {
                required: true,
                message: "密码不能为空!",
              },
            ]}
          >
            <Input.Password onChange={this.password} />
          </Form.Item>
          <Form.Item
            label="姓名"
            name="name"
            hasFeedback={name}
            validateStatus="success"
            rules={[
              {
                required: true,
                message: "姓名不能为空!",
              },
            ]}
          >
            <Input onChange={this.username} autoComplete="off" />
          </Form.Item>
          <Form.Item
            label="手机号码"
            name="phone"
            hasFeedback={phone}
            validateStatus="success"
            rules={[
              {
                required: true,
                message: "手机号不能为空!",
              },
            ]}
          >
            <Input onChange={this.phone} autoComplete="off" />
          </Form.Item>
          <Form.Item
            label="年龄"
            name="age"
            hasFeedback={age}
            validateStatus="success"
            rules={[
              {
                required: true,
                message: "年龄不能为空!",
              },
            ]}
          >
            <Input maxLength="2" onChange={this.age} autoComplete="off" />
          </Form.Item>
          <Form.Item
            label="性别"
            name="sex"
            rules={[
              {
                required: true,
                message: "必须选择性别!",
              },
            ]}
          >
            <Radio.Group onChange={this.sex} value={value}>
              <Radio value="男">男</Radio>
              <Radio value="女">女</Radio>
            </Radio.Group>
          </Form.Item>

          <Form.Item
            label="邮箱"
            name="email"
            hasFeedback={email}
            validateStatus="success"
            rules={[
              {
                required: true,
                message: "邮箱不能为空!",
              },
            ]}
          >
            <Input onChange={this.email} autoComplete="off" />
          </Form.Item>
          <Form.Item></Form.Item>
          <Form.Item {...tailLayout}>
            <Button
              style={{ marginRight: "50px" }}
              type="primary"
              htmlType="submit"
            >
              注册
            </Button>
            <Button onClick={this.back}> 返回登录</Button>
          </Form.Item>
        </Form>
      </div>
    );
  }
}
