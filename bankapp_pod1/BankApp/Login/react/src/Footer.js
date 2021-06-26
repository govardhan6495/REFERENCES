import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

class Footer extends React.Component {
    render() {
        return (
            <nav className="navbar navbar-expand-md  navbar-dark bg-info">
                <div className="container">
                    <div className="navbar-brand mx-auto">
                        <p className="h6">@Copyright bankingmanagementsystem 2021</p>
                    </div>
                </div>
            </nav>

        );
    }
}

export default Footer;