import React from 'react';
import './App.less';
import { Route, Switch, Redirect} from 'react-router-dom'
import Login from './pages/login'
import Admin from './admin';
import Home from './pages/home';

function App() {
  return(
    <div>
      <Switch>
        <Route path="/login" component={Login}/>
        <Route path="/" render={()=>
            <Admin>
                <Switch>
                    <Route path='/home' component={Home} />
                    <Redirect to="/home" />
                </Switch>
            </Admin>         
        } />
    </Switch>
    </div>
  );
}

export default App;
