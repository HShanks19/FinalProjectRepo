import CallRecordsTable from './CallRecordsTable';
import Colleagues from './Colleagues';
import Household from './Household';

const AssociatesRender = ({ data }) => {
  const { colleagues } = data;
  const called = data.callRecords;
  const { household } = data;
  const RenderColleagues = colleagues.map((d) => <Colleagues data={d} />);
  const RenderCallRecords = called.map((d) => <CallRecordsTable data={d} />);
  const RenderHousehold = household.map((d) => <Household data={d} />);

  return (
    <>
      <div>
        Recent Call History
      </div>
      <table className="table" id="callRecordsTable">
        <thead>
          <tr>
            <th scope="col">Time Stamp</th>
            <th scope="col">Receiver</th>
            <th scope="col">Receiver Phone Number</th>
            <th scope="col">View Receiver Bio</th>
          </tr>
        </thead>
        { RenderCallRecords }
      </table>
      <br />
      <div>
        Business Name:
        {' '}
        {data.businessName}
        <br />
        Business Address:
        {' '}
        {data.businessAddress}
        <br />
      </div>
      <table className="table" id="colleaguesTable">
        <thead>
          <tr>
            <th scope="col">Colleague</th>
            <th scope="col">Date of Birth</th>
          </tr>
        </thead>
        { RenderColleagues }
      </table>
      <table className="table" id="householdTable">
        <thead>
          <tr>
            <th scope="col">Household Member</th>
            <th scope="col">Date of Birth</th>
          </tr>
        </thead>
        <tbody>
          { RenderHousehold }
        </tbody>
      </table>
    </>
  );
};

export default AssociatesRender;
