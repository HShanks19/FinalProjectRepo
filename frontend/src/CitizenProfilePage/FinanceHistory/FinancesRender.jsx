import BankcardDTOsContainer from './bankcardDTOs';

const FinancesRender = ({ data }) => {
  const { bankcardDTOs } = data;
  const RenderBankcardDTOs = bankcardDTOs.map((d) => <BankcardDTOsContainer data={d} />);
  return (
    <>
      <container>
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
      </container>
    </>
  );
};

export default FinancesRender;
