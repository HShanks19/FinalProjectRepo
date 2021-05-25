import {
  Table,
} from 'react-bootstrap';
import EposTransactions from './eposTransactions';
import AtmTransactions from './atmTransactions';
import ErrorMessageTransactions from './ErrorTransactions';

const BankcardDTOsContainer = ({ data }) => {
  const { atmTransactions } = data;
  const { eposTransactions } = data;
  const RenderATMInformation = atmTransactions.map((d) => <AtmTransactions data={d} />);
  const RenderEPOSInformation = eposTransactions.map((d) => <EposTransactions data={d} />);
  return (
    <>
      <br />
      <div className="finances-titles">
        sort code:
        {' '}
        {data.sortCode}
      </div>
      <br />
      <Table striped bordered className="finances-table" variant="dark" id="eposTable">
        <thead>
          <tr>
            <th scope="col">Time Stamp</th>
            <th scope="col">Amount</th>
            <th scope="col">Account</th>
            <th scope="col">Vendor</th>
            <th scope="col">Address</th>
          </tr>
        </thead>
        { RenderEPOSInformation }
        { eposTransactions.length === 0
        && (
          <ErrorMessageTransactions />
        )}
      </Table>
      <Table striped bordered className="finances-table" variant="dark" id="atmTable">
        <thead>
          <tr>
            <th scope="col">Time Stamp</th>
            <th scope="col">Amount</th>
            <th scope="col">Operator</th>
            <th scope="col">Street Name</th>
            <th scope="col">Post Code</th>
          </tr>
        </thead>
        { RenderATMInformation }
        { atmTransactions.length === 0
        && (
          <ErrorMessageTransactions />
        )}
      </Table>
    </>
  );
};

export default BankcardDTOsContainer;
