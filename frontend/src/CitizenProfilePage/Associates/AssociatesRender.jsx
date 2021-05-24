import CallRecords from './CallRecords';
import Colleagues from './colleagues';

const AssociatesRender = ({ data }) => {
  const RenderColleagues = data.map((d) => <Colleagues data={d} />);
  const RenderCallRecords = data.map((d) => <CallRecords data={d} />);

  return (
    <>
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
      <table className="table" id="colleaguesTable">
        <thead>
          <tr>
            <th scope="col">Colleague</th>
            <th scope="col">Date of Birth</th>
          </tr>
        </thead>
        { RenderColleagues }
      </table>
    </>
  );
};

export default AssociatesRender;
