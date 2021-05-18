import React from 'react';
import ReactDOM from 'react-dom';
import Whereabouts from './Whereabouts'
import './styles.css';

function Whereabouts1() {
  return (
    <div>
      <Whereabouts />
    </div>
  );
}

const rootElement = document.getElementById('root');
ReactDOM.render(<Whereabouts1 />, rootElement);
