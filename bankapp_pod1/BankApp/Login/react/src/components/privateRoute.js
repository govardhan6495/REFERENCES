import React from 'react';
import { Route, Redirect } from 'react-router-dom';

export const privateRoute = ({ component: Component, ...rest }) => (
    <Route {...rest} render={props => (
        sessionStorage.getItem('user')
            ? <Component {...props} />
            : <Redirect to={{ pathname: '/login', state: { from: props.location } }} />
    )} />
)