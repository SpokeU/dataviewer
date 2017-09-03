import React, {Component} from 'react'
import {Route, Switch} from 'react-router-dom';

import Header from '../components/Header';
import DBs from '../components/DBs'
import Boards from '../components/Boards';
import Queries from '../components/Queries';
import Home from '../components/Home'

export default class App extends Component {

    render() {
        return (
            <div>
                <div className="container-fluid">
                <Header/>
                    <Switch>
                        <Route exact path='/' component={Home}/>
                        <Route path='/boards' component={Boards}/>
                        <Route path='/dbs' component={DBs}/>
                        <Route path='/queries' component={Queries}/>
                    </Switch>
                </div>
            </div>)
    }
}

function mapStateToProps(state) {
    return {}
}

function mapDispatchToProps(dispatch) {
    return {
        pageActions: bindActionCreators(pageActions, dispatch)
    }
}
