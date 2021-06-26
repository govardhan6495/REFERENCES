import { constants } from '../Constants';
import { alertActions } from '../Actions';
import { history } from '../Helpers';
import AuthService from '../Services/AuthService';


export const loginActions = {
    login,
    register,
};

function login(userName, password) {
    return dispatch => {
        dispatch(request({ userName }));
        AuthService.login(userName,password).
        then(
            user => { 
                dispatch(success(user));
                history.push('/');
            },
            error => {
                dispatch(failure(error));
                dispatch(alertActions.error(error));
            }

        );
    };

    function request(user) { return { type: constants.LOGIN_REQUEST, user } }
    function success(user) { return { type: constants.LOGIN_SUCCESS, user } }
    function failure(error) { return { type: constants.LOGIN_FAILURE, error } }
}



function register(user) {
    console.log('user',user);
   
    return dispatch => {
        dispatch(request(user));
        AuthService.register(user)
            .then(
                user => { 
                    console.log('userrrr',user);
                    dispatch(success(user));
                    history.push('/RegisterSucess');
                    dispatch(alertActions.success('Registration successful'));
                },
                error => {
                    dispatch(failure(error));
                    dispatch(alertActions.error(error));
                    dispatch(alertActions.success('Registration not done'));
                }
            );
    };

    function request(user) { return { type: constants.REGISTER_REQUEST, user } }
    function success(user) { return { type: constants.REGISTER_SUCCESS, user } }
    function failure(error) { return { type: constants.REGISTER_FAILURE, error } }
}





