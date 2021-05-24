const FinancesRender = ({ data }) => (
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
        <tbody>
          <tr>
            <th scope="row">{data.eposTimeStamp}</th>
            <td>{data.eposAmount}</td>
            <td>{data.eposAccountNumber}</td>
            <td>{data.vendor}</td>
            <td>{data.eposAddress}</td>
          </tr>
        </tbody>
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
        <tbody>
          <tr>
            <th scope="row">{data.atmTimeStamps}</th>
            <td>{data.atmAmount}</td>
            <td>{data.operator}</td>
            <td>{data.streetName}</td>
            <td>{data.postCode}</td>
          </tr>
        </tbody>
      </table>
    </container>
  </>
);

export default FinancesRender;
