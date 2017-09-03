import React from 'react'
import {Link} from "react-router-dom";

export default () => {
    return (
        <nav className='navbar navbar-expand-lg navbar-dark bg-dark fixed-top'>

                <div className='navbar-header'>
                    <Link className='navbar-brand' to='/'>Brand</Link>
                </div>


                <div className='collapse navbar-collapse' id='bs-example-navbar-collapse-1'>
                    <ul className='nav navbar-nav'>
                        <li className='active'><Link to='/dbs'>DBs<span className='sr-only'>(current)</span></Link></li>
                        <li><Link to='/boards'>Boards</Link></li>
                        <li><Link to='/queries'>Queries</Link></li>
                    </ul>

            </div>
        </nav> )
}