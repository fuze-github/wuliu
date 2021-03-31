import React, { Component } from "react";
import { alluser, mation, code } from "../../request/network";
import { AudioOutlined } from "@ant-design/icons";
import { Table, Modal, Button, Input, Space } from "antd";
export default class Seedata extends Component {
  state = {
    phone: "",
    password: "",
    email: "",
    loginname: "",
    sex: "",
    age: "",
    time: "",
    time: "",
    loading: false,
    visible: false,
    tips: "获取验证码",
    isflag: false,
    text: "",
  };
  showModal = () => {
    this.setState({
      visible: true,
    });
  };

  handleOk = () => {
    this.setState({ loading: true });
    setTimeout(() => {
      this.setState({ loading: false, visible: false });
    }, 3000);
  };

  handleCancel = () => {
    this.setState({ visible: false });
  };
  onSearch = (value) => {
    var codenum = "";
    for (var i = 1; i <= 6; i++) {
      const num = Math.floor(Math.random() * 10);
      codenum += num;
    }
    const params = {
      mobile: "18772473687",
      param: `${codenum}`,
      templateId: "SMS_75800186",
    };
    code(params).then((res) => {
      console.log(res.data);
    });

    this.setState({
      isflag: true,
      tips: 60,
    });

    this.timer = setInterval(() => {
      if (this.state.tips > 0) {
        this.setState({
          tips: this.state.tips - 1,
          text: "s后重新获取",
        });
      } else if (this.state.tips <= 0) {
        this.setState({
          tips: "重新获取",
          text: "",
          isflag: false,
        });
        clearInterval(this.timer);
      }
    }, 1000);
  };
  componentDidMount() {
    /*    alluser().then(res=>{
            console.log(res);
        }) */

    mation(1).then((res) => {
      const {
        phone,
        password,
        email,
        loginname,
        time,
        age,
        sex,
      } = res.data.data[0];
      this.setState({
        phone,
        password,
        email,
        loginname,
        sex,
        age,
        time,
      });
    });
  }
  baocun = () => {
    //修改某一项保存之后....
    console.log(12322);
  };
  render() {
    const {
      phone,
      password,
      email,
      loginname,
      time,
      age,
      sex,
      visible,
      loading,
      tips,
      isflag,
      text,
    } = this.state;

    const { Column, ColumnGroup } = Table;
    const { Search } = Input;

    const suffix = (
      <AudioOutlined
        style={{
          fontSize: 16,
          color: "#1890ff",
        }}
      />
    );
    const data = [
      {
        key: "1",
        label: `头像:`,
        msg: "123",
        edit: "更换头像",
      },
      {
        key: "2",
        label: `账号:`,
        msg: phone,
        edit: "修改",
      },
      {
        key: "3",
        label: `登录名:`,
        msg: loginname,
        edit: "修改",
      },
      {
        key: "4",
        label: `密码:`,
        msg: password,
        edit: "修改",
      },
      {
        key: "5",
        label: `邮箱:`,
        msg: email,
        edit: "修改",
      },
      {
        key: "6",
        label: `年龄:`,
        msg: age,
        edit: "修改",
      },
      {
        key: "7",
        label: `性别:`,
        msg: sex,
        edit: "修改",
      },
      {
        key: "8",
        label: `登录时间:`,
        msg: time,
        edit: "重新编辑",
      },
    ];

    return (
      <div className="seedata">
        <Table
          dataSource={data}
          scroll={{ x: "70%" }}
          onRow={(record) => {
            return {
              onClick: (event) => {
                if (event.target.innerText === record.edit) {
                  this.setState({ visible: true });
                }
              }, // 点击行
            };
          }}
        >
          <ColumnGroup title={`${loginname}的个人信息`} align="center">
            <Column
              title="信息"
              dataIndex="label"
              key="label"
              width="15%"
              align="right"
            />
            <Column
              title=""
              dataIndex="msg"
              key="msg"
              width="40%"
              align="left"
            />
            <Column
              title="操作"
              key="edit"
              dataIndex="edit"
              width="45%"
              align="right"
              onClick={this.update}
            />
          </ColumnGroup>
        </Table>
        <Modal
          visible={visible}
          title="修改手机号"
          onOk={this.handleOk}
          onCancel={this.handleCancel}
          centered
          width="500px"


          afterClose={this.baocun}
          footer={[
            <Button key="back" onClick={this.handleCancel}>
              返回
            </Button>,
            <Button
              key="submit"
              type="primary"
              loading={loading}
              onClick={this.handleOk}
            >
             确定
            </Button>,
          ]}
        >
          <div style={{display:"none"}}>
          <p>您正在修改登录手机号:</p>
          <Input maxLength="6" style={{ width: "320px",height:"45px" }} />{" "}
          <Button onClick={this.onSearch} 
          style={{width:"125px",height:"45px"}}
          type="primary"
          disabled={isflag}>
            {tips === "获取验证码" ? `${tips}` : `${tips}${text}`}
          </Button>
          </div>
        </Modal>
      </div>
    );
  }
}
