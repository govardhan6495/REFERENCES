import React ,{Component} from 'react';
import { Link } from 'react-router-dom';
import { connect } from 'react-redux';

import { loginActions } from '../Actions';

class Login extends Component {
    constructor(props) {
        super(props);

        // reset login status
      //  this.props.logout();

        this.state = {
            userName: '',
            password: '',
            submitted: false
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(e) {
        const { name, value } = e.target;
        this.setState({ [name]: value });
    }

    handleSubmit(e) {
        e.preventDefault();

        this.setState({ submitted: true });
        const { userName, password } = this.state;
        if (userName && password) {
            this.props.login(userName, password);
        }
    }

    render() {
        const { loggingIn } = this.props;
        const { userName, password, submitted } = this.state;
        return (
            <div className="col-md-6 col-md-offset-3">
                <h2>Login</h2>
                <form name="form" onSubmit={this.handleSubmit}>
                    <div className={'form-group' + (submitted && !userName ? ' has-error' : '')}>
                        <label htmlFor="username">Username</label>
                        <input type="text" className="form-control" name="userName" value={userName} onChange={this.handleChange} />
                        {submitted && !userName &&
                            <div className="help-block" style={{ color: "red" }}>Username is required</div>
                        }
                    </div>
                    <div className={'form-group' + (submitted && !password ? ' has-error' : '')}>
                        <label htmlFor="password">Password</label>
                        <input type="password" className="form-control" name="password" value={password} onChange={this.handleChange} />
                        {submitted && !password &&
                            <div className="help-block" style={{ color: "red" }}>Password is required</div>
                        }
                    </div>
                    <div className="form-group">
                        <button className="btn btn-primary">Login</button>
                       
                        <Link to="/register" className="btn btn-link">Register</Link>
                    </div>
                </form>
            </div>
        );
    }
}

function mapState(state) {
    const { loggingIn } = state.authentication;
    return { loggingIn };
}

const actionCreators = {
    login: loginActions.login
};

const connectedLoginPage = connect(mapState, actionCreators)(Login);
export { connectedLoginPage as Login };