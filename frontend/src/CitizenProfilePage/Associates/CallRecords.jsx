import axios from 'axios';
import { useState } from 'react';
import { Modal, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.css';

const CallRecords = ({ data }) => {
  const [show, setShow] = useState(0);
  const [forenameM, setForenamesM] = useState('');
  const [surnameM, setSurnameM] = useState('');
  const [dOB, setDateOfBirthM] = useState('');
  const [addressM, setAddressM] = useState('');
  const [townM, setTownM] = useState('');
  const [postcodeM, setPostcodeM] = useState('');
  const closeModal = () => setShow(0);
  const makeRequest = () => {
    axios.get(`http://54.74.11.52:5001/getCitizenByNumber/${data.receiverMSISDN}`)
      .then((response) => {
        const ModalData = response.data;
        setShow(1);
        setForenamesM(ModalData.forenames);
        setSurnameM(ModalData.surname);
        setDateOfBirthM(ModalData.dateOfBirth);
        setAddressM(ModalData.address);
        setTownM(ModalData.town);
        setPostcodeM(ModalData.postcode);
      })
      .catch((err) => console.log(err));
  };
  const handleChange = () => {
    makeRequest();
  };
  return (
    <>
      <tr>
        <th scope="row">{data.timestamp}</th>
        <td>{data.receiverName}</td>
        <td>{data.receiverMSISDN}</td>
        <div>
          <Button type="button" className="btn btn-danger btn-block" onClick={handleChange}>View Profile</Button>
        </div>
      </tr>
      <>
        <Modal show={show}>
          <Modal.Header>
            <Modal.Title>Receiver Information</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <h4>
              Citizen Name:
              {' '}
              {forenameM}
              {' '}
              {surnameM}
            </h4>
            <h5>
              Date of Birth:
              {' '}
              {dOB}
            </h5>
            <h5>
              Address:
              {' '}
              {addressM}
              {townM}
              {postcodeM}
            </h5>
          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={closeModal}>Close Modal</Button>
          </Modal.Footer>
        </Modal>
      </>
    </>
  );
};

export default CallRecords;
