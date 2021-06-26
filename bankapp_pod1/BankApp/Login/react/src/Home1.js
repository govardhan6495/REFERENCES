import React ,{Component} from 'react';
import { Link } from 'react-router-dom';


class Home1 extends React.Component {
    constructor(props) {
        super(props);

    }

    

    render() {
        return (
            <div className="col-md-10 col-md-offset-3">
                <h2>Welcome to bank Management System  Existing Users Please Login!! </h2>
               
                    <div className="form-group">
                    <Link to="/login" className="btn btn-link">Login</Link>
                       
                        <Link to="/register" className="btn btn-link">Register</Link>
                    </div>
              
            </div>
        );
    }
}

export default Home1;