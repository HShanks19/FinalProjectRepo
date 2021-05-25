import BankcardDTOsContainer from './bankcardDTOs';

const FinancesRender = ({ data }) => {
  const { bankcardDTOs } = data;
  const RenderBankcardDTOs = bankcardDTOs.map((d) => <BankcardDTOsContainer data={d} />);
  return (
    <>
      <div>
        Bank:
        {' '}
        {data.bank}
        {' '}
        Account Number:
        {' '}
        {data.accountNumber}
      </div>
      { RenderBankcardDTOs }
    </>
  );
};

export default FinancesRender;
