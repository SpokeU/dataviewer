import React, {Component} from 'react'

export default class DBs extends Component {

    constructor(props) {
        super(props);
        this.togglePanel = this.togglePanel.bind(this);
        this.state = {
            expanded: false
        }
    }

    togglePanel() {
        this.setState({expanded: !this.state.expanded});
    }

    render() {
        return (
            <div className='row'>
                <div className='col-md-12'>

                    <div className='row'>
                        <button className="btn btn-add pull-right">+New</button>
                    </div>
                    <div className='row'>
                        <div className='collaplible-data-list'>
                            <div className='collaplible-data-list-item'>
                                <div className='item-header'>
                                    <span
                                        className={this.state.expanded ? 'glyphicon glyphicon-chevron-down' : 'glyphicon glyphicon-chevron-right'}
                                        aria-hidden='true' onClick={this.togglePanel}></span>
                                    <img />
                                    <h4>Mongo connection</h4>
                                    <span className='header-conneciton-string'>localhost:20017/admin</span>
                                </div>
                                <div className={!this.state.expanded ? 'hidden' : 'item-data'}>
                                    <form>
                                        <fieldset>
                                            <div className='form-group item-input'>
                                                <label htmlFor='exampleInputName2'>Host</label>
                                                <input type='text' className='form-control' id='exampleInputName2'
                                                       placeholder='Jane Doe'/>
                                            </div>
                                            <div className='form-group item-input'>
                                                <label htmlFor='exampleInputEmail2'>Port</label>
                                                <input type='email' className='form-control' id='exampleInputEmail2'
                                                       placeholder='jane.doe@example.com'/>
                                            </div>
                                        </fieldset>
                                        <fieldset>
                                            <div className='form-group item-input'>
                                                <label htmlFor='exampleInputName2'>user</label>
                                                <input type='text' className='form-control' id='exampleInputName2'
                                                       placeholder='Jane Doe'/>
                                            </div>
                                            <div className='form-group item-input'>
                                                <label htmlFor='exampleInputEmail2'>pass</label>
                                                <input type='email' className='form-control' id='exampleInputEmail2'
                                                       placeholder='jane.doe@example.com'/>
                                            </div>
                                        </fieldset>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
