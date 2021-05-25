import reactLogo from '../react_logo.svg';
import springLogo from '../spring_logo.svg';

const Footer = () => (
  <div className="footer">
    <p>
      An app made using
      <a href="https://reactjs.org/">
        <img src={reactLogo} className="react-footer-logo" alt="react-logo" />
      </a>
      and
      <a href="https://spring.io">
        <img src={springLogo} className="spring-footer-logo" alt="react-logo" />
      </a>
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
