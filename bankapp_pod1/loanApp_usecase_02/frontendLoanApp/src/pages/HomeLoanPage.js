import React, { Component } from 'react'
import { Link } from 'react-router-dom'
import axios from 'axios'

class HomeLoanPage extends Component {
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

    submitHandler = e => {
      e.preventDefault()
      console.log(this.state)
      axios.post('http://localhost:9002/hloan/v1/apply', this.state)
          .then(response => {
              console.log(response)
          })
          .catch(error => {
              console.log(error)
          })
  }

    handleSubmit(event) {
        event.preventDefault();
      
        if(this.validate()){
            console.log(this.state);
      
            let input = {};
            input["cmpname"] = "";
            input["desgn"] = "";
            input["totexp"] = "";
            input["curexp"] = "";
            input["aninc"] = "";
            this.setState({input:input});
            console.log(input);
            alert('Your request is submited');
        }

        axios.post('http://localhost:9002/hloan/v1/apply', this.state.input)
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
    
        
        if (!input["cmpname"]) {
            isValid = false;
            errors["cmpname"] = "Please enter your company name.";
          }
        if (!input["desgn"]) {
            isValid = false;
            errors["desgn"] = "Please enter your desgination.";
        }          
        if (!input["totexp"]) {
            isValid = false;
            errors["totexp"] = "Please enter your total experience.";
        }

        if (!input["curexp"]) {
            isValid = false;
            errors["curexp"] = "Please enter your exp with current company.";
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


    render() {
        return (
            <div className="container bg-grey">
              <form onSubmit={this.handleSubmit}>
                  <h4 className="text-center py-4">HomeLoan Form</h4>
                  <div className="row">
                  <div className="form-group col-6">
                          <label htmlFor="cmpname">Company Name:</label>
                          <input 
                            type="text"
                            name="cmpname"
                            value={this.state.input.cmpname}
                            onChange={this.handleChange}
                            className="form-control"
                            placeholder="Enter Company Name"
                            id="cmpname" />
                            <div className="text-danger">{this.state.errors.cmpname}</div>
                        </div>
                        <div className="form-group col-6">
                          <label htmlFor="desgn">Designation:</label>
                          <input 
                              type="text"
                              name="desgn"
                              value={this.state.input.desgn}
                              onChange={this.handleChange}
                              class="form-control"
                              placeholder="Enter Designation"
                              id="desgn" />
                              <div className="text-danger">{this.state.errors.desgn}</div>
                      </div>
                  </div>
                  <div className="row">
                  <div className="form-group col-6">
                          <label htmlFor="totexp">Total Experience:</label>
                          <input 
                              type="number"
                              name="totexp"
                              value={this.state.input.totexp}
                              onChange={this.handleChange}
                              className="form-control"
                              placeholder="Enter Total Experience"
                              id="totexp"
                              min="0" />
                              <div className="text-danger">{this.state.errors.totexp}</div>
                      </div>
                      <div className="form-group col-6">
                          <label htmlFor="curexp">Experience with current Company:</label>
                          <input 
                              type="number"
                              name="curexp"
                              value={this.state.input.curexp}
                              onChange={this.handleChange}
                              className="form-control"
                              placeholder="Enter Experience with current Company"
                              id="curexp"
                              min="0" />
                            <div className="text-danger">{this.state.errors.curexp}</div>
                      </div>
                  </div>
                  <div className="row">
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
                    <button className="btn btn-success"  type="submit">ApplyHomeLoan </button>
                    <Link to="/"><button className="btn btn-danger" onClick={this.handleChange} style={{marginLeft: "20px"}}>Cancel</button></Link>
                  </div>                  
 
              </form>
                
            </div>
        )
    }
}

export default HomeLoanPage