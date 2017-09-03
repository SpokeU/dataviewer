import React from 'react'
import { render } from 'react-dom'
import { Provider } from 'react-redux'
import './styles/app.css'
import configureStore from './store/configureStore'
import './styles/app.css'
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';

import App from './containers/App'
;


import {BrowserRouter, HashRouter} from 'react-router-dom';

const store = configureStore()

render(
  <Provider store={store}>
      <BrowserRouter>
          <App/>
      </BrowserRouter>
  </Provider>,
  document.getElementById('root')
)
