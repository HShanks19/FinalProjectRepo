import eposTransactions from './eposTransactions';
import atmTransactions from './atmTransactions';

const FinancesRender = ({ data }) => {
  const RenderATMInformation = data.map((d) => <atmTransactions data={d} />);
  const RenderEPOSInformation = data.map((d) => <eposTransactions data={d} />);
  return (
    <>
      <container>
        <div>
          Bank:
          {' '}
          {data.bank}
          sortCode:
          {' '}
          {data.sortCode}
          accountNumber:
          {' '}
          {data.accountNumber}
        </div>
        <table className="table" id="eposTable">
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
        </table>
        <table className="table" id="atmTable">
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
        </table>
      </container>
    </>
  );
};

export default FinancesRender;
