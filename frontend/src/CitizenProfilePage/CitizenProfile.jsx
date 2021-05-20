/* eslint no-template-curly-in-string: "error" */
import {
  BrowserRouter as Route, Switch, useRouteMatch,
} from 'react-router-dom';
import Biography from './Biography/Biography';
import Associates from './Associates/Associates';
import Finances from './FinanceHistory/Finances';
import Whereabouts from './Whereabouts/Whereabouts';
import './CitizenProfile.css';

const CitizenPage = () => {
  const { path } = useRouteMatch();

  return (
    <>
      <Switch>
        <Route path={`${path}/Biography`}>
          <Biography />
        </Route>
        <Route path={`${path}/Associates`}>
          <Associates />
        </Route>
        <Route path={`${path}/Finances`}>
          <Finances />
        </Route>
        <Route path={`${path}/Whereabouts`}>
          <Whereabouts />
        </Route>
      </Switch>
    </>
  );
};

export default CitizenPage;
