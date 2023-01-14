import React, { useState, useEffect } from 'react'
import FlightsService from '../services/FlightsService'

const ListFlightsComponent = () => {

    const [flights, setFlights] = useState([])

     useEffect(() => {

        FlightsService.getAllFlights().then((response) => {
            setFlights(response.data)
            console.log(response.data)
        }).catch(error => {
            console.log(error);
        })
     }, [])
     

    return (
    <div className="container">
       <h2 className="text-center">List Flights</h2> 
       <table className="table table-bordered table-striped">
        <thead>
            <th>Flights Id</th>

            <th>Flights order number</th>

            <th>Flights amount</th>

            <th>Flights start date</th>

            <th>Flights end date</th>

            <th>Flights type</th>
        </thead>
        <tbody>
            {
                flights.map(
                    flight =>
                    <tr key = {flight.id}>
                        <td>{flight.id}</td>
                        <td>{flight.orderNumber}</td>
                        <td>{flight.amount}</td>
                        <td>{flight.startDate}</td>
                        <td>{flight.endDate}</td>
                        <td>{flight.type  }</td>
                    </tr>
                )
            }
        </tbody>
       </table>
    </div>
  )
}

export default ListFlightsComponent