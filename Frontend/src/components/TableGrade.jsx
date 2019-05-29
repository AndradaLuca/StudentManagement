import React, {Component} from 'react';
import {BootstrapTable,
    TableHeaderColumn} from 'react-bootstrap-table';

class TableGrade extends Component {
    render() {
        return (
            <div>
                <BootstrapTable data={this.props.data} className="d-sm-table-row"  >
                    <TableHeaderColumn isKey
                                       dataField='name'
                                       width="185">
                        Materie
                    </TableHeaderColumn>

                    <TableHeaderColumn dataField='grade'
                                       width="110">
                        Nota
                    </TableHeaderColumn>





                </BootstrapTable>
            </div>
        );
    }
}

export default TableGrade;