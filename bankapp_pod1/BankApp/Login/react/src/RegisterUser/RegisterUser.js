import React from 'react';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';
import { Accordion, Card } from "react-bootstrap";
import './register.css';
import { constants } from '../Constants';


import { loginActions } from '../Actions';

class RegisterUser extends React.Component {
 
    constructor(props) {
        super(props);

        this.state = {
            customer: { username: '',name: '', password: '',gender:'',gaurdianName:'',address:'',
            nationality:'',state:'',country:'',email:'',gaurdian:'',maritalStatus:'',contactNo:'',
            registnDate:'',accountType:'',citizenStatus:'',initialDepoAmt:'',branchName:'',
            idenProof:'',idenDocNum:'',refAccntName:'',refAccntNumber:'',refAccntAddress:''
            },
            submitted: false,
            regErrors: {} 
        };
       

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
  
    

    handleChange=(event)=> {
        console.log('event',event.target);
        const { name, value } = event.target;
        const { customer } = this.state;
        this.setState({
            customer: {
                ...customer,
                [name]: value
            }
        });
        console.log("state",this.state);
        
    }
    handleSelectChange=(event)=>{
        const { customer } = this.state;
        this.setState({
            customer: {
                ...customer,
                [event.target.name]: event.target.value
            }
        });
        

        event.target.value==='savings'? this.setState({
            customer:{
                ...customer,['initialDepoAmt']:'10000',['accountType']:'savings'}}):
                this.setState({
                    customer:{
                        ...customer,['initialDepoAmt']:'5000',['accountType']:'salary'}});

        
    }

    handleSubmit=(event)=> {
        event.preventDefault();
        if(this.handleFormValidation()){
            console.log('formvalid')
        this.setState({ submitted: true });
        const { customer } = this.state;
        console.log('customer',this.state.customer);
            this.props.register(this.state.customer);
        }
        
    }

    

    render() {
      //  const { registering } = this.props;
        const { customer, submitted } = this.state;
        const { userNameError,nameError,passError,gaurdianError,gaurdianNameError ,addressError,
            nationalityError,stateError,countryError,emailIdErr,genderError,maritalStatusError,
            contctNoErrr,regtrnDateError,accntTypeError,brnchNameError,
            citizenError} = this.state.regErrors;
        return (
            <div>
                <h2>Register</h2>
                <form name="form" onSubmit={this.handleSubmit} class="form-horizontal" >
                    <Accordion defaultActiveKey="0">
                        <Card >
                            <Accordion.Toggle as={Card.Header} eventKey="0" >
                                User Information
    </Accordion.Toggle>
                            <Accordion.Collapse eventKey="0">
                                <Card.Body>

                                    <div className={'form-group' + (!submitted && !customer.username ? ' has-error' : '')}>
                                        <label htmlFor="username">User Name</label><span className="asterisk">*</span>
                                        <input type="text" className="form-control" name="username"
                                         value={customer.username} onChange={this.handleChange}
                                         />
                                        {!submitted && !customer.username &&
                                            <div className="help-block " style={{ color: "red" }}>{userNameError}</div>
                                        }
                                    </div>
                                    <div className={'form-group' + (!submitted && !customer.name ? ' has-error' : '')}>
                                        <label htmlFor="name">Name</label><span className="asterisk">*</span>
                                        <input type="text" className="form-control" name="name" value={customer.name}
                                         onChange={this.handleChange} />
                                        {!submitted && !customer.name &&
                                            <div className="help-block" style={{ color: "red" }}>{nameError}</div>
                                        }
                                    </div>
                                    <div className={'form-group' + (!submitted && !customer.password ? ' has-error' : '')}>
                                        <label htmlFor="password">Password</label><span className="asterisk">*</span>
                                        <input type="password" className="form-control" name="password" value={customer.password}
                                         onChange={this.handleChange} />
                                        {!submitted && !customer.password &&
                                            <div className="help-block" style={{ color: "red" }}>{passError}</div>
                                        }
                                    </div>
                                    <div className={'form-group'}>
                                        <label htmlFor="Gaurdian Type">Gaurdian Type</label><span className="asterisk">*</span>

                                        <select class="form-control" name='gaurdian' onChange={this.handleChange} value={customer.gaurdian}>
                                            <option value="select">--Select--</option>
                                            <option value="major">Major</option>
                                            <option value="minor">Minor</option>
                                        </select>
                                        {!submitted && !customer.gaurdian &&
                                            <div className="help-block" style={{ color: "red" }}>{gaurdianError}</div>
                                        }

                                    </div>
                                    <div className={'form-group' + (!submitted && !customer.gaurdianName ? ' has-error' : '')}>
                                        <label htmlFor="gaurdianName">Gaurdian Name</label><span className="asterisk">*</span>
                                        <input type="text" className="form-control" name="gaurdianName" value={customer.gaurdianName} onChange={this.handleChange} />
                                        {!submitted && !customer.gaurdianName &&
                                            <div className="help-block" style={{ color: "red" }}>{gaurdianNameError}</div>
                                        }
                                    </div>
                                    <div className={'form-group' + (!submitted && !customer.address ? ' has-error' : '')}>
                                        <label htmlFor="address">Address</label><span className="asterisk">*</span>
                                        <input type="textarea" className="form-control" name="address" value={customer.address} onChange={this.handleChange} />
                                        {!submitted && !customer.address &&
                                            <div className="help-block" style={{ color: "red" }}>{addressError}</div>
                                        }
                                    </div>
                                    <div className={'form-group' + (!submitted && !customer.nationality ? ' has-error' : '')}>
                                        <label htmlFor="nationality">Nationality</label><span className="asterisk">*</span>
                                        <input type="text" className="form-control" name="nationality" value={customer.nationality} onChange={this.handleChange} />
                                        {!submitted && !customer.nationality &&
                                            <div className="help-block" style={{ color: "red" }}>{nationalityError}</div>
                                        }
                                    </div>
                                    <div className={'form-group' + (!submitted && !customer.state ? ' has-error' : '')}>
                                        <label htmlFor="state">State</label><span className="asterisk">*</span>
                                        <input type="text" className="form-control" name="state" value={customer.state} onChange={this.handleChange} />
                                        {!submitted && !customer.state &&
                                            <div className="help-block" style={{ color: "red" }}>{stateError}</div>
                                        }
                                    </div>
                                    <div className={'form-group' + (!submitted && !customer.country ? ' has-error' : '')}>
                                        <label htmlFor="country">Country</label><span className="asterisk">*</span>
                                        <input type="text" className="form-control" name="country" value={customer.country} onChange={this.handleChange} />
                                        {!submitted && !customer.country &&
                                            <div className="help-block" style={{ color: "red" }}>{countryError}</div>
                                        }
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
                                    <div className={'form-group' + (!submitted && !customer.email ? ' has-error' : '')}>
                                        <label htmlFor="email">Email</label><span className="asterisk">*</span>
                                        <input type="email" className="form-control" name="email" value={customer.email} onChange={this.handleChange} />
                                        {!submitted && !customer.email &&
                                            <div className="help-block" style={{ color: "red" }}>{emailIdErr}</div>
                                        }
                                    </div>
                                    <div className={'form-group' + (!submitted && !customer.gender ? ' has-error' : '')}>
                                        <label htmlFor="gender">Gender</label><span className="asterisk">*</span>
                                        <select class="form-control"  name='gender' value={customer.gender}  onChange={this.handleChange}>
                                        <option value="select">--Select--</option>
                                            <option value="male">Male</option>
                                            <option value="female">Female</option>
                                            <option value="other">Other</option>
                                        </select>
                                        {!submitted && !customer.gender &&
                                            <div className="help-block" style={{ color: "red" }}>{genderError}</div>
                                        }
                                    </div>
                                    <div className={'form-group' + (!submitted && !customer.maritalStatus ? ' has-error' : '')}>
                                        <label htmlFor="maritalStatus">Marital Status</label><span className="asterisk">*</span>
                                        <select class="form-control" name='maritalStatus' value={customer.maritalStatus}  onChange={this.handleChange}>
                                        <option value="select">--Select--</option>
                                            <option value="married">Married</option>
                                            <option value="Unmarried">Unmarried</option>
                                            <option value="other">Other</option>
                                        </select>
                                        {!submitted && !customer.maritalStatus &&
                                            <div className="help-block" style={{ color: "red" }}>{maritalStatusError}</div>
                                        }
                                    </div>
                                    <div className={'form-group' + (!submitted && !customer.contactNo ? ' has-error' : '')}>
                                        <label htmlFor="contactNo">Contact No</label><span className="asterisk">*</span>
                                        <input type="number" className="form-control" name="contactNo" value={customer.contactNo} onChange={this.handleChange} />
                                        {!submitted && !customer.contactNo &&
                                            <div className="help-block" style={{ color: "red" }}>{contctNoErrr}</div>
                                        }
                                    </div>



                                </Card.Body>
                            </Accordion.Collapse>
                        </Card>
                        <Card >
                            <Accordion.Toggle as={Card.Header} eventKey="2" >
                                Account Details
    </Accordion.Toggle>
                            <Accordion.Collapse eventKey="2">
                                <Card.Body>
                                    <div className={'form-group' + (!submitted && !customer.registnDate ? ' has-error' : '')}>
                                        <label htmlFor="registnDate">Registration Date</label><span className="asterisk">*</span>
                                        <input type="date" className="form-control" name="registnDate" value={customer.registnDate} onChange={this.handleChange} />
                                        {!submitted && !customer.registnDate &&
                                            <div className="help-block" style={{ color: "red" }}>{regtrnDateError}</div>
                                        }
                                    </div>
                                    <div className={'form-group' + (!submitted && !customer.accountType ? ' has-error' : '')}>
                                        <label htmlFor="accountType">Account Type</label><span className="asterisk">*</span>
                                        <select name="accountType" class="form-control"  name='accountType' value={customer.accountType}  onChange={this.handleSelectChange}>
                                            <option value="select">--Select--</option>
                                            <option value="savings">Savings</option>
                                            <option value="salary">Salary</option>
                                        </select>
                                        {!submitted && !customer.accountType &&
                                            <div className="help-block" style={{ color: "red" }}>{accntTypeError}</div>
                                        }
                                    </div>
                                    <div className={'form-group' + (!submitted && !customer.initialDepoAmt ? ' has-error' : '')}>
                                        <label htmlFor="initialDepoAmt">Initial Deposit Amount</label><span className="asterisk">*</span>
                                        <input type="number" className="form-control" name="initialDepoAmt"
                                         value={customer.initialDepoAmt} readOnly/>
                                        
                                    </div>
                                    <div className={'form-group' + (!submitted && !customer.branchName ? ' has-error' : '')}>
                                        <label htmlFor="branchName">Branch Name</label><span className="asterisk">*</span>
                                        <input type="text" className="form-control" name="branchName" value={customer.branchName} onChange={this.handleChange} />
                                        {!submitted && !customer.branchName &&
                                            <div className="help-block" style={{ color: "red" }}>{brnchNameError}</div>
                                        }
                                    </div>
                                   
                                    <div className={'form-group' + (!submitted && !customer.citizenStatus ? ' has-error' : '')}>
                                        <label htmlFor="citizenStatus">CitizenShip Status</label><span className="asterisk">*</span>
                                        <input type="text" className="form-control" name="citizenStatus" value={customer.citizenStatus} onChange={this.handleChange} />
                                        {!submitted && !customer.citizenStatus &&
                                            <div className="help-block" style={{ color: "red" }}>{citizenError}</div>
                                        }
                                    </div>
                                    <div className={'form-group' + (submitted && !customer.idenProof ? ' has-error' : '')}>
                                        <label htmlFor="idenProof">Identification Proof</label><span className="asterisk">*</span>
                                       {/*  <input type="text" className="form-control" name="idenProof" value={customer.idenProof} onChange={this.handleChange} /> */}
                                        <select name="idenProof" class="form-control"  name='idenProof' value={customer.idenProof}  onChange={this.handleChange}>
                                            <option value="select">--Select--</option>
                                            <option value="pan">PAN</option>
                                            <option value="license">LICENSE</option>
                                            <option value="passport">PASSPORT</option>
                                        </select>
                                        {!submitted && !customer.idenProof &&
                                            <div className="help-block" style={{ color: "red" }}>Proof is Required</div>
                                        }
                                    </div>
                                    <div className={'form-group' + (submitted && !customer.idenDocNum ? ' has-error' : '')}>
                                        <label htmlFor="idenDocNum">Identification Document Number</label><span className="asterisk">*</span>
                                        <input type="number" className="form-control" name="idenDocNum" value={customer.idenDocNum} onChange={this.handleChange} />
                                        {!submitted && !customer.idenDocNum &&
                                            <div className="help-block" style={{ color: "red" }}>Identification Document Number is Required</div>
                                        }
                                    </div>

                                </Card.Body>
                            </Accordion.Collapse>
                        </Card>
                        <Card>
                            <Accordion.Toggle as={Card.Header} eventKey="3">
                                Reference Details
    </Accordion.Toggle>
                            <Accordion.Collapse eventKey="3">
                                <Card.Body>

                                    <div className={'form-group' + (submitted && !customer.refAccntName ? ' has-error' : '')}>
                                        <label htmlFor="refAccntName">Reference Account Holder Name</label><span className="asterisk">*</span>
                                        <input type="text" className="form-control" name="refAccntName" value={customer.refAccntName} onChange={this.handleChange} />
                                        {!submitted && !customer.refAccntName &&
                                            <div className="help-block" style={{ color: "red" }}>Reference Account Holder Name is Required</div>
                                        }
                                    </div>
                                    <div className={'form-group' + (submitted && !customer.refAccntNumber ? ' has-error' : '')}>
                                        <label htmlFor="refAccntNumber">Reference Account Number</label><span className="asterisk">*</span>
                                        <input type="number" className="form-control" name="refAccntNumber" value={customer.refAccntNumber} onChange={this.handleChange} />
                                        {!submitted && !customer.refAccntNumber &&
                                            <div className="help-block" style={{ color: "red" }}>Reference Account Number is Required</div>
                                        }
                                    </div>
                                    <div className={'form-group' + (submitted && !customer.refAccntAddress ? ' has-error' : '')}>
                                        <label htmlFor="refAccntAddress">Reference Account Holder Addess</label><span className="asterisk">*</span>
                                        <input type="text" className="form-control" name="refAccntAddress" value={customer.refAccntAddress} onChange={this.handleChange} />
                                        {!submitted && !customer.refAccntAddress &&
                                            <div className="help-block" style={{ color: "red" }}>Reference Account Holder Addess is Required</div>
                                        }
                                    </div>
                                </Card.Body>
                            </Accordion.Collapse>
                        </Card>
                    </Accordion >
                    <div>
                    <div className="form-group">
                    <button className="btn btn-primary">Register</button>
                        <Link to="/login" className="btn btn-link">Cancel</Link>
                    </div>
                    </div>
                </form>
            </div>
        );
    }
    handleFormValidation=() =>{   
        console.log('formvalidation') ;
          
        let regErrors = {};    
        let formIsValid = true;    
        const { customer} = this.state;

       
        if (!customer.username) {    
            formIsValid = false;    
            regErrors["userNameError"] = constants.REGISTER_USER_NAME_ERROR   
        }  
        if(!customer.name)  {
            formIsValid = false;    
            regErrors["nameError"] = constants.REGISTER_NAME_ERROR 
        }
        if(!customer.password)  {
            formIsValid = false;    
            regErrors["passError"] = constants.REGISTER_PASSWORD_ERROR 
        }else if(customer.password && customer.password.length<6){
            console.log('short')
            formIsValid = false;    
            regErrors["passError"] = constants.REGISTER_SHORTPASSWORD_ERROR 
        }
        if (customer.gaurdian === '' || customer.gaurdian === "select"){
            formIsValid = false;    
            regErrors["gaurdianError"] = constants.REGISTER_GAURDIAN_ERROR 
        }
        if (!customer.gaurdianName){
            formIsValid = false;    
            regErrors["gaurdianNameError"] = constants.REGISTER_GAURDIAN_NAME_ERROR 
        }
        if (!customer.address){
            formIsValid = false;    
            regErrors["addressError"] = constants.REGISTER_ADDRESS_ERROR 
        }
        if (!customer.nationality){
            formIsValid = false;    
            regErrors["nationalityError"] = constants.REGISTER_NATIONALITY_ERROR 
        }
        if (!customer.state){
            formIsValid = false;    
            regErrors["stateError"] = constants.REGISTER_STATE_ERROR 
        }
        if (!customer.country){
            formIsValid = false;    
            regErrors["countryError"] = constants.REGISTER_COUNTRY_ERROR 
        }
        if (!customer.email) {    
            formIsValid = false;    
            regErrors["emailIdErr"] = constants.REGISTER_EMAIL_ERROR;    
        }    
        else if (customer.email && !(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(customer.email))) {    
            formIsValid = false;    
            regErrors["emailIdErr"] = constants.REGISTER_EMAIL_INVALID;    
        }  
        if (customer.gender === '' || customer.gender === "select"){
            formIsValid = false;    
            regErrors["genderError"] = constants.REGISTER_GENDER_ERROR 
        }  
        if (customer.maritalStatus === '' || customer.maritalStatus === "select"){
            formIsValid = false;    
            regErrors["maritalStatusError"] = constants.REGISTER_MARITALSTATUS_ERROR 
        }  
        if (!customer.contactNo) {    
            formIsValid = false;    
            regErrors["contctNoErrr"] =     constants.REGISTER_CONTACTNO_ERROR
        }    
        // else  if(customer.contactNo){    
        //     var mobPattern = /^(?:(?:\\+|0{0,2})91(\s*[\\-]\s*)?|[0]?)?[789]\d{9}$/;    
        //     if (!mobPattern.test(customer.contactNo)) {    
        //         formIsValid = false;    
        //         regErrors["contctNoErrr"] =   constants.REGISTER_CONTACTNO_INVALID  
        //     }    
        // }  
        if (!customer.registnDate) {    
            formIsValid = false;    
            regErrors["regtrnDateError"] = constants.REGISTER_RGNDATE_ERROR    
        }    
        // else if(customer.registnDate) {    
        //     var pattern = /^(0[1-9]|1[0-9]|2[0-9]|3[0-1])\/(0[1-9]|1[0-2])\/([0-9]{4})$/;    
        //     if (!pattern.test(customer.registnDate)) {    
        //         formIsValid = false;    
        //         regErrors["regtrnDateError"] = constants.REGISTER_RGNDATE_INVALID 
        //     }     
        // }  
        if (customer.accountType === '' || customer.accountType === "select"){
            formIsValid = false;    
            regErrors["accntTypeError"] = constants.REGISTER_ACCNTTYPE_ERROR
        }  
        if (!customer.branchName){
            formIsValid = false;    
            regErrors["brnchNameError"] = constants.REGISTER_BRANCH_REQUIRED 
        }
        if (!customer.citizenStatus){
            formIsValid = false;    
            regErrors["citizenError"] = constants.REGISTER_CITIZEN_ERROR 
        }
        
        this.setState({ regErrors: regErrors });  
        console.log('regErrors',regErrors) ;  

        return formIsValid;    
    }    
    
}

function mapState(state) {
    const { registering } = state.registration;
    return { registering };
}

const actionCreators = {
    register: loginActions.register
}


const connectedRegisterPage = connect(mapState, actionCreators)(RegisterUser);
export { connectedRegisterPage as RegisterUser };