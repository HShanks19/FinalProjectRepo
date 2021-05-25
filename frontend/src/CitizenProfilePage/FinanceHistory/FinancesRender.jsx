import BankcardDTOsContainer from './bankcardDTOs';

const FinancesRender = ({ data }) => {
  const { bankcardDTOs } = data;
  const RenderBankcardDTOs = bankcardDTOs.map((d) => <BankcardDTOsContainer data={d} />);
  return (
    <>
      <br />
      <div className="finances-titles">
        Bank:
        {' '}
        {data.bank}
        {' '}
        <br />
        Account Number:
        {' '}
        {data.accountNumber}
      </div>
      { RenderBankcardDTOs }
    </>
  );
};

export default FinancesRender;
