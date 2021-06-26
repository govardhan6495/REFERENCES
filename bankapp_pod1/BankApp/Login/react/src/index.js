import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import {Provider} from 'react-redux';
import {store} from './Helpers';

// setup fake backend
//import { configureFakeBackend } from './Helpers';
//configureFakeBackend()

ReactDOM.render(

 <Provider store={store}>
 <App />
 </Provider>,
  document.getElementById('root')
);
