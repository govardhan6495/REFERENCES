import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';

class RegisterSucess extends React.Component {
    render() {
        return (
            <div className="col-md-10 col-md-offset-3">
            <h2>Registration Success Please Login!! </h2>
           
                <div className="form-group">
                <Link to="/login" className="btn btn-link">Login</Link>

                </div>
          
        </div>

        );
    }

}


export default RegisterSucess;