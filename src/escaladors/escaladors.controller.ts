import {
  Controller,
  Get,
  Param,
  Query,
} from '@nestjs/common';

import { EscaladorsService } from './escaladors.service';

import { FilterEscaladorDto } from './dto/filter-escalador.dto';

@Controller('escaladors')
export class EscaladorsController {

  constructor(
    private readonly escaladorsService: EscaladorsService,
  ) {}

  @Get()
  findAll(
    @Query() filters: FilterEscaladorDto,
  ) {

    return this.escaladorsService.findAll(filters);
  }

  @Get(':id')
  findOne(
    @Param('id') id: string,
  ) {

    return this.escaladorsService.findOne(Number(id));
  }
}