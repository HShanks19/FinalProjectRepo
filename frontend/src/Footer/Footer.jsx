import logo from '../logo.svg';

const Footer = () => (
  <div className="footer">
    <p>
      An app made using
      <img src={logo} style={{ height: 25, width: 30 }} alt="react-logo" />
      by
      {' '}
      <a href="https://github.com/HShanks19">HShanks19</a>
      ,
      {' '}
      <a href="https://github.com/jpqa1">jpqa1</a>
      ,
      {' '}
      <a href="https://github.com/MeganMette">MeganMette</a>
      {' '}
      and
      {' '}
      <a href="https://github.com/joshua-hs">joshua-hs</a>
    </p>
  </div>
);

export default Footer;
