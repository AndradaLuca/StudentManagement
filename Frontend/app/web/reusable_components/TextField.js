import React from 'react'

export default class TextField extends React.Component {
    render() {
        return(
            <input
                className = {this.props.className}
                type = {this.props.type}
                value = {this.props.value}
                name = {this.props.name}
                onChange = {this.props.onChange}
            />            
        )
    }
}