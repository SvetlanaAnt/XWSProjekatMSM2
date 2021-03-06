import React, { useState, useEffect } from 'react';
import { Container, Row, Col, Button } from 'react-bootstrap'
import AgentRequestsComponent from '../../components/Request/AgentRequestsComponent';
import SpinnerContainer from '../Common/SpinnerContainer';
import RequestService from '../../services/RequestService';
import ReportService from '../../services/ReportService';
import { useDispatch } from 'react-redux';
import AgentRequestDetailComponent from '../../components/Request/AgentRequestDetailComponent';
import { putSuccessMsg, putErrorMsg } from '../../store/common/actions';
import ReportSubmitComponent from '../../components/Report/ReportSubmitComponent';
import FormModalContainer from '../Common/FormModalContainer';

const AgentRequestDetailContainer = (props) => {
    const dispatch = useDispatch();
    const id = props.match.params.id;
    const [isFetch, setIsFetch] = useState(false);
    const [request, setRequest] = useState();
    const [showForm, setShowForm] = useState(false);
    const [validated, setValidated] = useState(false);
    const [selectedAd, setSelectedAd] = useState();
    const [mileage, setMileage] = useState();
    const [coordinates, setCoordinates] = useState([]);

    const fetchRequest = async () => {
        setIsFetch(false);
        const result = await RequestService.fetchRequest({ "id": id });
        setRequest(result);
        setIsFetch(true);
    }

    // const fetchCoordinates = async () => {
    //     const result = await RequestService.fetchCoordinates();
    //     setCoordinates(result);
    // }

    const submitReport = async (payload) => {
        const result = await ReportService.submitReport(payload);
        if (result === "Izvjestaj uspjesno dodat.") {
            dispatch(putSuccessMsg(result));
        }
        fetchRequest();
    }

    useEffect(() => {
        fetchRequest();
        //fetchCoordinates
    }, [id]);

    const handleSubmitReport = (event) => {
        console.log(selectedAd);
        event.preventDefault();
     
        const form = event.target;
        let data = null;
        if (form.checkValidity() === false) {
            event.stopPropagation();
            setValidated(true);
        } else {
             data = {
                "distanceTraveled": form.distanceTraveled.value,
                "description": form.description.value,
                "adId": selectedAd,
                "email": request.endUserEmail
            };
            console.log(data)
            submitReport(data);
            setValidated(false);
            setShowForm(false);
            fetchRequest();
        }
    }

    return (
        <Container>
            <FormModalContainer show={showForm} setShow={setShowForm} name={'Izvjestaj'} data={mileage} footer={false} onSubmit={handleSubmitReport} validated={validated} component={ReportSubmitComponent} />
            <Row>
                <Col md={12} xs={12}>
                    {
                        isFetch ? <AgentRequestDetailComponent coordinates={coordinates} request={request} setShow={setShowForm} setSelectedAd={setSelectedAd} setMileage={setMileage} /> : <SpinnerContainer />
                    }
                </Col>
            </Row>
        </Container >
    );
}

export default AgentRequestDetailContainer;
