import { constants } from '../Constants';

let user = JSON.parse(sessionStorage.getItem('user'));
const initialState = user ? { loggedIn: true, user } : {};

export function authentication(state = initialState, action) {
  switch (action.type) {
    case constants.LOGIN_REQUEST:
      return {
        loggingIn: true,
        user: action.user
      };
    case constants.LOGIN_SUCCESS:
      return {
        loggedIn: true,
        user: action.user
      };
    case constants.LOGIN_FAILURE:
      return {};
    case constants.LOGOUT:
      return {};
    default:
      return state
  }
}