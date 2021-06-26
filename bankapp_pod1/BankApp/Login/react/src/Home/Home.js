import React ,{Component} from 'react';
import { Link } from 'react-router-dom';


class Home extends Component {
    constructor(props) {
        super(props);

       
       
    }

   

    render() {
        return (
            <div className="col-md-6 col-md-offset-3">
                <h2>Home</h2>
              
                    <Link to="/login" className="btn btn-link">Login</Link>
                        <Link to="/register" className="btn btn-link">Register</Link>
                    </div>
                
           
        );
    }
}




export default Home;