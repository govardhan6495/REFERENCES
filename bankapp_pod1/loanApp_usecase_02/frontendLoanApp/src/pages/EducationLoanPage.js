import React, { Component} from 'react';
import { Link } from 'react-router-dom'
import Axios from 'axios'

class Educationloanpage extends Component {
    constructor() {
        super();
        this.state = {
            input: {},
            errors: {}
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }
    
    handleChange(event) {
        let input = this.state.input;
        input[event.target.name] = event.target.value;
      
        this.setState({
          input
        });
    }

    handleSubmit(event) {
        event.preventDefault();
        // const URL = 'http://localhost:9002/eloan/v1/apply'
        if(this.validate()){
            console.log(this.state);
      
            let input = {};
            input["cfee"] = "";
            input["cname"] = "";
            input["fname"] = "";
            input["focup"] = "";
            input["ftotexp"] = "";
            input["fcurexp"] = "";
            input["rtcno"] = "";
            input["aninc"] = "";
            this.setState({input:input});
            
            console.log(input);
            alert('Your request is submited');
        }

        Axios.post('http://localhost:9002/eloan/v1/apply', this.state.input)
            .then(response => {
                console.log(response)
            })
            .catch(error => {
                console.log(error)
            })
    }

    validate(){
        let input = this.state.input;
        let errors = {};
        let isValid = true;
    
        if (!input["cfee"]) {
            isValid = false;
            errors["cfee"] = "Please enter your course fee.";
        }
        if (!input["cname"]) {
            isValid = false;
            errors["cname"] = "Please enter your course name.";
          }
        if (!input["fname"]) {
            isValid = false;
            errors["fname"] = "Please enter your father occupation.";
        }  
        if (!input["focup"]) {
            isValid = false;
            errors["focup"] = "Please enter your father occupation.";
        }
        if (!input["ftotexp"]) {
            isValid = false;
            errors["ftotexp"] = "Please enter your father's total experience.";
        }

        if (!input["fcurexp"]) {
            isValid = false;
            errors["fcurexp"] = "Please enter your father's exp with current company.";
          }
        if (!input["rtcno"]) {
            isValid = false;
            errors["rtcno"] = "Please enter your Ration Card No.";
          }
        if(typeof["rtcno"] !== "undefined") {
            if(!input["rtcno"].match(/^[A-Z][0-9]$/)){
              isValid=false;
              errors["rtcno"] = "Please enter Valid RationCardNo."
            }

        }

        if (!input["aninc"]) {
            isValid = false;
            errors["aninc"] = "Please enter your Annual Income.";
          }

          this.setState({
            errors: errors
          });

          return isValid;
    }

    handleCancel(){
        this.props.history.push('/cancel');
    }


    render () {
        
        return(
            <div className="container bg-grey">
                <form onSubmit={this.handleSubmit}><br /><br />
                  <h4 className="text-center">Education Loan Form</h4><br />
                    <div className="row">
                    <div className="form-group col-6">
                        <label htmlFor="cname">Course :</label>
                        <input 
                            type="text"
                            name="cname"
                            value={this.state.input.cname}
                            onChange={this.handleChange}
                            className="form-control"
                            placeholder="Enter Course Name"
                            id="cname" />
                            <div className="text-danger">{this.state.errors.cname}</div>
                    </div>
                    <div className="form-group col-6">
                        <label htmlFor="cfee"> Course Fee: </label>
                        <input 
                            type="number"
                            name="cfee"
                            value={this.state.input.cfee}
                            onChange={this.handleChange}
                            className="form-control"
                            placeholder="Enter Course Fee"
                            id="cfee"
                            min="0" />
                            <div className="text-danger">{this.state.errors.cfee}</div>
                    </div>
                    </div>

                    <div className="row">
                    <div className="form-group col-6">
                        <label htmlFor="fname">Father Name:</label>
                        <input 
                            type="text"
                            name="fname"
                            value={this.state.input.fname}
                            onChange={this.handleChange}
                            className="form-control"
                            placeholder="Enter Father Name"
                            id="fname" />
                            <div className="text-danger">{this.state.errors.fname}</div>
                    </div>
                    <div className="form-group col-6">
                        <label htmlFor="focup">Father's Occupation :</label>
                        <input 
                            type="text"
                            name="focup"
                            value={this.state.input.focup}
                            onChange={this.handleChange}
                            className="form-control"
                            placeholder="Enter Father's Occupation"
                            id="focup" />
                            <div className="text-danger">{this.state.errors.focup}</div>
                    </div>
                    </div>
                    <div className="row">
                    <div className="form-group col-6">
                        <label htmlFor="ftotexp">Father's Total Exp:</label>
                        <input 
                            type="number"
                            name="ftotexp"
                            value={this.state.input.ftotexp}
                            onChange={this.handleChange}
                            className="form-control"
                            placeholder="Enter Father's Total Exp"
                            id="ftotexp"
                            min="0" />
                            <div className="text-danger">{this.state.errors.ftotexp}</div>
                    </div>
                    <div className="form-group col-6">
                        <label htmlFor="fcurexp">Father's Exp with current Company:</label>
                        <input 
                            type="number"
                            name="fcurexp"
                            value={this.state.input.fcurexp}
                            onChange={this.handleChange}
                            className="form-control"
                            placeholder="Enter Father's Exp with current Company"
                            id="fcurexp"
                            min="0" />
                            <div className="text-danger">{this.state.errors.fcurexp}</div>
                    </div>
                    </div>
                    <div className="row">
                    <div className="form-group col-6">
                        <label htmlFor="rtcno">Ration Card No: </label>
                        <input 
                            type="text"
                            name="rtcno"
                            value={this.state.input.rtcno}
                            onChange={this.handleChange}
                            className="form-control"
                            placeholder="Enter ration card no."
                            id="rtcno" />
                            <div className="text-danger">{this.state.errors.rtcno}</div>
                    </div>
                    <div className="form-group col-6">
                        <label htmlFor="aninc">Annual Income</label>
                        <input 
                            type="number"
                            name="aninc"
                            value={this.state.input.aninc}
                            onChange={this.handleChange}
                            className="form-control"
                            placeholder="Enter Annual Income"
                            id="aninc"
                            min="0" />
                            <div className="text-danger">{this.state.errors.aninc}</div>
                    </div>
                    </div>
                    <div className="py-4">
                    <button className="btn btn-success"  type="submit">Apply-EducationLoan </button>
                    <Link to="/"><button className="btn btn-danger" onClick={this.handleChange} style={{marginLeft: "20px"}}>Cancel</button></Link>
                  </div>                  
                </form>
            </div>
        );
    }
}

export default Educationloanpage ;