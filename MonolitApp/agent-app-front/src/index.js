import React from 'react';
import ReactDOM from 'react-dom';
import { Router } from 'react-router-dom';
import { Provider } from 'react-redux';
import { createBrowserHistory } from 'history';
import store from './store';
import AppRouter from './AppRouter';
import NavBar from './containers/NavBar';
import InformationToastsContainer from './containers/Common/InformationToastsContainer';
import { ToastProvider } from 'react-toast-notifications';
import { YMaps } from 'react-yandex-maps';

export const history = createBrowserHistory();

ReactDOM.render(
  <YMaps>
    <Provider store={store}>
      <Router history={history}>
        <NavBar />
        <AppRouter />
        <ToastProvider>
          <InformationToastsContainer />
        </ToastProvider>
      </Router>
    </Provider>
  </YMaps >,
  document.getElementById('root')
);

