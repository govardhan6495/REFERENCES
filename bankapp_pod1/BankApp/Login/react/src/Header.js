import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';


class Header extends React.Component {
    render() {
        return (
            <nav className="navbar navbar-expand-md navbar-dark bg-info">
                <div className="container  h-100">
                    <div className="navbar-brand mx-auto">
                        <p className="h4">Bank Management System </p>
                    </div>
                </div>
            </nav>

        );
    }

}


export default Header;