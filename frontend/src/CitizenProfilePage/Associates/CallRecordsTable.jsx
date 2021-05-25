import CallRecords from './CallRecords';

const CallRecordsTable = ({ data }) => {
  const callRecords = data.mobileCallRecords;
  const RenderCallRecords = callRecords.map((d) => <CallRecords data={d} />);
  return (
    <tbody>
      { RenderCallRecords }
    </tbody>
  );
};

export default CallRecordsTable;
