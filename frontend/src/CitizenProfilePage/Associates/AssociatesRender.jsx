import {
  Table,
} from 'react-bootstrap';
import CallRecordsTable from './CallRecordsTable';
import Colleagues from './Colleagues';
import Household from './Household';
import ErrorMessage from './Error';

const AssociatesRender = ({ data }) => {
  const { colleagues } = data;
  const called = data.callRecords;
  const { household } = data;
  const RenderColleagues = colleagues.map((d) => <Colleagues data={d} />);
  const RenderCallRecords = called.map((d) => <CallRecordsTable data={d} />);
  const RenderHousehold = household.map((d) => <Household data={d} />);

  return (
    <>
      <br />
      <div className="associates-titles">
        Recent Call History
      </div>
      <br />
      <Table striped bordered className="associates-table" variant="dark" id="callRecordsTable">
        <thead>
          <tr>
            <th scope="col">Time Stamp</th>
            <th scope="col">Receiver</th>
            <th scope="col">Receiver Phone Number</th>
            <th scope="col">View Receiver Bio</th>
          </tr>
        </thead>
        { RenderCallRecords }
        { called.length === 0
          && (
            <ErrorMessage />
          )}
      </Table>
      <br />
      <div className="associates-titles">
        Business Name:
        {' '}
        {data.businessName}
        <br />
        Business Address:
        {' '}
        {data.businessAddress}
        <br />
      </div>
      <br />
      <Table striped bordered className="associates-table" variant="dark" id="colleaguesTable">
        <thead>
          <tr>
            <th scope="col">Colleague</th>
            <th scope="col">Date of Birth</th>
            <th scope="col">View Receiver Bio</th>
          </tr>
        </thead>
        <tbody>
          { RenderColleagues }
          { colleagues.length === 0
          && (
            <ErrorMessage />
          )}
        </tbody>
      </Table>
      <br />
      <div className="associates-titles">
        Household
      </div>
      <br />
      <Table striped bordered className="associates-table" variant="dark" id="householdTable">
        <thead>
          <tr>
            <th scope="col">Household Member</th>
            <th scope="col">Date of Birth</th>
            <th scope="col">View Receiver Bio</th>
          </tr>
        </thead>
        <tbody>
          { RenderHousehold }
          { household.length === 0
          && (
            <ErrorMessage />
          )}
        </tbody>
      </Table>
    </>
  );
};

export default AssociatesRender;
