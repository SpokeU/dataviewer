import React, {Component} from 'react'

export default class Queries extends Component {
    render() {
        return (
            <div className='row'>
                <div className='col-md-12 query-list'>Queries list /admin

                    <div className="row query">
                            <h4 className="query-name">Query name</h4>
                            <p className="query-string">SELECT * FROM USERS WHERE USER_ID = 'GAMOLA'</p>
                    </div>

                </div>
            </div>
        )
    }
}
