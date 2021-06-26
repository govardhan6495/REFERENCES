import React, { Component } from 'react';
import { Accordion,Card } from "react-bootstrap";
import { reduxForm, Field } from "redux-form";


const genderOptions=[{value:"male",label:"Mr"},{value:"female",label:"Mrs/Miss"}];

 class Register extends Component {
  constructor(props) {
    super(props);
   
  }
  

  state={selectedGender:''};
  setGender=()=>{
    
  };
   handleSubmit = (event) => {
    console.log('handle subit');
  
}

  render() {
    console.log('state',this.state);
    const selectedGender=this.state//move to props
    return (
      <div>
        <form onSubmit={this.handleSubmit} >
<Accordion defaultActiveKey="0">
  <Card>
    <Accordion.Toggle as={Card.Header} eventKey="0">
     User Information
    </Accordion.Toggle>
    <Accordion.Collapse eventKey="0">
      <Card.Body>
      
      <div class="row">
              <div class="col-sm-2">
                <label for="userName" class="label-style">User Name</label>
              </div>
              <div class="form-group col-lg-4">
              <Field
                  name="userName"
                  type="text"
                  class="form-control" 
                  id="userName"
                  placeholder="Username"
                />
              
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2">
                <label for="name" class="label-style">Name</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="name" class="form-control" placeholder="Name" required  />
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2">
                <label for="password" class="label-style">Password</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="password" id="name" class="form-control" placeholder="password" required/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2"> 
                <label for="gaurdian type" class="label-style">Gaurdian Type</label>
              </div>
              <div class="form-group col-lg-4">
              <select class="form-control" >
  <option defaultValue>Gaurdian</option>
  <option value="major">Major</option>
  <option value="minor">Minor</option>
</select>
             </div>



            
            </div>
            <div class="row">
              <div class="col-sm-2"> 
                <label for="gaurdian Name" class="label-style">Gaurdian Name</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="gaurdianName" class="form-control" placeholder="Gaurdian Name" required/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2"> 
                <label for="Address" class="label-style">Address</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="textarea" id="address" class="form-control" placeholder="Address" required/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2"> 
                <label for="citizenship" class="label-style">Nationality</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="nationality" class="form-control" placeholder="Nationality" required/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2"> 
                <label for="state" class="label-style">State</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="state" class="form-control" placeholder="State" required/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2"> 
                <label for="country" class="label-style">Country</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="country" class="form-control" placeholder="Country" required/>
              </div>
            </div>
            

           


      </Card.Body>
    </Accordion.Collapse>
  </Card>
  <Card>
    <Accordion.Toggle as={Card.Header} eventKey="1">
     Personal Details
    </Accordion.Toggle>
    <Accordion.Collapse eventKey="1">
      <Card.Body>
      <form class="form-horizontal" >
      <div class="row">
              <div class="col-sm-2">
                <label for="email" class="label-style">Email</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="email" id="userName" class="form-control" placeholder="email" required/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2">
                <label for="gender" class="label-style">Gender</label>
              </div>
              <div class="form-group col-lg-4">
              <select class="form-control" >
  <option defaultValue>Gender</option>
  <option value="male">Male</option>
  <option value="female">Female</option>
  <option value="other">Other</option>
</select>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2">
                <label for="maritalStatus" class="label-style">Marital Status</label>
              </div>
              <div class="form-group col-lg-4">
              <select class="form-control" >
  <option selected>Gender</option>
  <option value="married">Married</option>
  <option value="unmarried">Unmarried</option>
  <option value="other">Other</option>
</select>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2">
                <label for="contact" class="label-style">Contact No</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="contact" class="form-control" placeholder="contact" required/>
              </div>
            </div>
            </form>
      </Card.Body>
    </Accordion.Collapse>
  </Card>
  <Card>
    <Accordion.Toggle as={Card.Header} eventKey="2">
     Account Details
    </Accordion.Toggle>
    <Accordion.Collapse eventKey="2">
      <Card.Body>
      <form class="form-horizontal" >
      <div class="row">
              <div class="col-sm-2">
                <label for="date" class="label-style">Registration Date</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="date" id="registrationDate" class="form-control" placeholder="Registration Date" required/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2">
                <label for="email" class="label-style">Account Type</label>
              </div>
              <div class="form-group col-lg-4">
              <select  name="accountType"class="form-control"  onChange={()=>this.onChangeAccount()}>
                  <option defaultValue>AccountType</option>
                    <option value="savings">Savings</option>
                    <option value="salary">Salary</option>
            </select>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2">
                <label for="Branch Name" class="label-style">Branch Name</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="branchName" class="form-control" placeholder="Branch Name" required/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2">
                <label for="citizenStatus" class="label-style">CitizenShip Status</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="citizenStatus" class="form-control" placeholder="CitizenShip Status" required/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2">
                <label for="initialAmount" class="label-style">Initial Deposit Amount</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="number" id="initialAmount" class="form-control" placeholder="Initial Deposit Amount" required/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2">
                <label for="identProof" class="label-style">Identification Proof</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="identProof" class="form-control" placeholder="Identification Proof" required/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2">
                <label for="idenDocnum" class="label-style">Identification Document Number</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="number" id="idenDocnum" class="form-control" placeholder="identification document number" required/>
              </div>
            </div>
            </form>
            </Card.Body>
            
    </Accordion.Collapse>
  </Card>
  <Card>
    <Accordion.Toggle as={Card.Header} eventKey="3">
     Reference Details
    </Accordion.Toggle>
    <Accordion.Collapse eventKey="3">
      <Card.Body>
      <form class="form-horizontal" >
      <div class="row">
              <div class="col-sm-2">
                <label htmlFor="refAccountName" class="label-style">Reference Account Holder Name</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="refAccountName" class="form-control" placeholder="Reference Account Holder Name" required/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2">
                <label htmlFor="refAccountNumber" class="label-style">Reference Account Number</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="number" id="usrefAccountNumbererName" class="form-control" placeholder="Reference Account Number" required/>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-2">
                <label htmlFor="refAccountAddr" class="label-style">Reference Account Holder Addess</label>
              </div>
              <div class="form-group col-lg-4">
                <input type="text" id="refAccountAddr" class="form-control" placeholder="Reference Account Holder Addess<" required/>
              </div>
            </div>
            
            </form>
            </Card.Body>
            
    </Accordion.Collapse>
  </Card>
</Accordion>
<div>
<button onClick={this.handleSubmit}>
 Register
</button>
</div>
</form>
</div>







              

      
    );
  }
  onChangeAccount=()=>{

  }
  handleUserNameChange=(e)=>{
    console.log('handleUserNameChange',e);
    this.setState({userName: e.target.value});
 }
   onRegister(){
   
     console.log("buttonClick");

  }
}

Register = reduxForm({
  form: 'Registerform'
})(Register);

export default Register;


