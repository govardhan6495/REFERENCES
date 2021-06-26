  
import axios from "axios";

const API_URL = "http://localhost:8080/api/auth/";

class AuthService {
  login(username, password) {
    return axios
      .post(API_URL + "login", {
        username,
        password
      })
      .then(response => {
        if (response.data.accessToken) {
          sessionStorage.setItem("user", JSON.stringify(response.data));
        }

        return response.data;
      });
  }

  logout() {
    sessionStorage.removeItem("user");
  }

  register(user) {
    console.log('USERRRR',user);
    return axios.post(API_URL + "register",user);
  // let response=axios.post(API_URL + "register",user);
  // console.log('response....',response);
  }

  getCurrentUser() {
    return JSON.parse(sessionStorage.getItem('user'));;
  }
}

export default new AuthService();