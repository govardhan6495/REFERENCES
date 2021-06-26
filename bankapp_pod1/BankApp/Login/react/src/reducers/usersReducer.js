import { constants } from '../Constants';

export function users(state = {}, action) {
  switch (action.type) {
    case constants.GETALL_REQUEST:
      return {
        loading: true
      };
    case constants.GETALL_SUCCESS:
      return {
        items: action.users
      };
    case constants.GETALL_FAILURE:
      return { 
        error: action.error
      };
  
    default:
      return state
  }
}