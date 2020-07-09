import React, { useState, useEffect } from 'react';

import { useDispatch, useSelector } from 'react-redux';
import { Container, Row, Col } from 'react-bootstrap';

import PaginationContainer from '../Pagination/PaginationContainer';
import PaginationSize from '../../components/Pagination/PaginationSize';
import { calendarSelector } from '../../store/ad/selectors';
import { fetchCalendar, addTerm } from '../../store/ad/actions';
import SpinnerContainer from '../Common/SpinnerContainer';
import Availability from '../../components/Ad/Availability';


const AvailabilityContainer = (props) => {
    const dispatch = useDispatch();
    const [validated, setValidated] = useState(false);

    const calendar = useSelector(calendarSelector);
    const [carCalendarTermList, setCarCalendarTermList] = useState([]);
    const [startDate, setStartDate] = useState(null);
    const [endDate, setEndDate] = useState(null);
    const [flag, setFlag] = useState(true);

    //occupation
    const [occupationStart, setOccupationStart] = useState(null);
    const [occupationEnd, setOccupationEnd] = useState(null);

    useEffect(() => {
        dispatch(
            fetchCalendar({
                'id': props.adId
            })
        );
    }, []);


    const previewCalendar = () => {
        let list = [];
        let i = 1;
        if (calendar.isFetch) {
            if (calendar.data != "") {
                // setCarCalendarTermList(calendar.data);
                // console.log("--------------------");
                // console.log(carCalendarTermList)

                calendar.data.map((term) => {
                    console.log(term);

                    let ss = term.startDate.substring(0, 10);
                    let ss2 = term.startDate.substring(11, 16);
                    let ee = term.endDate.substring(0, 10);
                    let ee2 = term.endDate.substring(11, 16);
                    ss = ss + " " + ss2;
                    ee = ee + " " + ee2;
                    list.push(
                        <tr key={i}>
                            <td>{i}</td>
                            <td>{ss}</td>
                            <td>{ee}</td>

                            {/* <td align="right">
                            <Button variant="outline-success" onClick={() => { props.handleEdit(carManufacturer); }}>Izmjeni</Button>
                        </td>
                        <td align="right">
                            <Button variant="outline-danger" onClick={() => { props.handleDelete(carManufacturer.id); }}>Obriši</Button>
                        </td> */}
                        </tr>
                    );
                    i++;
                })
            }

        }
        return list;
    }

    const addTermToCalendar = () => {
        if (startDate != null && endDate != null) {
            let flag = false;
            if (calendar.isFetch) {
                if (calendar.data != "") {
                    calendar.data.map((temp) => {
                        if (temp.startDate <= startDate && startDate <= temp.endDate) {
                            flag = true;
                            console.log("start date je izmedju")
                        } else if (temp.startDate <= endDate && endDate <= temp.endDate) {
                            flag = true;
                            console.log("end date je izmedju")
                        }
                    });
                }
            }

            if (flag === true) {
                console.log("ne mozes da dodas datum.");
                alert("Datumi se ne smeju preklapati.");
            } else {
                console.log("DODAJ DATUM.");
                add();

                // setValidated(false);
            }
        }
    }

    const add = () => {
        
        let temp = {
            'adId': props.adId,
            'startDate': startDate,
            'endDate': endDate
        };
        console.log(temp);
        dispatch(addTerm(JSON.stringify(temp)));
    }

    const getCurrentDate = () => {
        let newDate = new Date()
        let date = newDate.getDate();
        let month = newDate.getMonth() + 1;
        let year = newDate.getFullYear();
        let hours = newDate.getHours();
        let minutes = newDate.getMinutes();
        let rez = "";
        if (month < 10) {
            month = "0" + month;
        }
        if (date < 10) {
            date = "0" + date;
        }
        if (hours < 10) {
            hours = "0" + hours;
        }
        if (minutes < 10) {
            minutes = "0" + minutes;
        }
        rez = year + "-" + month + "-" + date + "T" + hours + ":" + minutes;
        return rez;
    }
    const handleStartDate = (event) => {
        setStartDate(event.target.value);
    }
    const handleEndDate = (event) => {
        setEndDate(event.target.value);
    }
    const handleOccupationStart = (event)=> {

    }
    const handleOccupationEnd = (event)=> {
        
    }
    const addOccupation =(event) => {
        
    }

    return (
        <Container >
            <Row>
                <Col >

                    <Availability
                        adId={props.adId} setAdId={props.setAdId}
                        flagAvailability={props.flagAvailability}
                        setFlagAvailability={props.setFlagAvailability}
                        handleBack={props.handleBack}
                        // getCalendar={getCalendar}
                        previewCalendar={previewCalendar}
                        addTermToCalendar={addTermToCalendar}
                        getCurrentDate={getCurrentDate}
                        handleStartDate={handleStartDate}
                        handleEndDate={handleEndDate}
                        startDate={startDate}
                        endDate={endDate}
                        flag={flag}
                        validated={validated}
                        carCalendarTermList={carCalendarTermList}

                        //occupation
                        occupationStart={occupationStart}
                        occupationEnd={occupationEnd}
                        handleOccupationStart={handleOccupationStart}
                        handleOccupationEnd={handleOccupationEnd}
                        addOccupation={addOccupation}
                    />

                </Col>
            </Row>
        </Container>
    );
}

export default AvailabilityContainer;